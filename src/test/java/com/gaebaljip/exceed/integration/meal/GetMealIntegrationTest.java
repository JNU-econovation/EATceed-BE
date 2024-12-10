package com.gaebaljip.exceed.integration.meal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gaebaljip.exceed.adapter.in.meal.response.GetMealFoodResponse;
import com.gaebaljip.exceed.adapter.in.member.response.GetMealAndWeightResponse;
import com.gaebaljip.exceed.adapter.out.jpa.member.MemberRepository;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.InitializeS3Bucket;
import com.gaebaljip.exceed.common.IntegrationTest;
import com.gaebaljip.exceed.common.WithMockUser;
import com.gaebaljip.exceed.common.dto.AllAnalysisDTO;
import com.gaebaljip.exceed.common.dto.MealRecordDTO;

@InitializeS3Bucket
public class GetMealIntegrationTest extends IntegrationTest {

    @Autowired private MemberRepository memberRepository;

    @Test
    @DisplayName("성공 : 오늘 먹은 식사 조회")
    @WithMockUser
    void when_getTodayMeal_expected_success() throws Exception {
        // given
        long memberId = 1L;

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/meal")
                                .contentType(MediaType.APPLICATION_JSON));

        String responseBody = resultActions.andReturn().getResponse().getContentAsString();

        MemberEntity member = memberRepository.findById(memberId).get();

        // then
        ApiResponse.CustomBody<GetMealAndWeightResponse> getMealResponseCustomBody =
                om.readValue(
                        responseBody,
                        new TypeReference<ApiResponse.CustomBody<GetMealAndWeightResponse>>() {});
        Double maintainCalorie =
                getMealResponseCustomBody.getResponse().maintainMealDTO().calorie();
        Double targetCalorie = getMealResponseCustomBody.getResponse().targetMealDTO().calorie();

        assertAll(
                () -> assertTrue(maintainCalorie > 0),
                () -> assertTrue(targetCalorie > maintainCalorie),
                () -> assertEquals(member.getWeight(), 76.0),
                () -> assertEquals(member.getTargetWeight(), 78.0));
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("성공 : 미래 날짜로 켈린더 상세 조회시 식사 기록은 존재하지 않고, 방문하지도 않았다.")
    @WithMockUser
    void when_getSpecificMeal_expected_isVisited_false_mealRecord_existed() throws Exception {
        MemberEntity memberEntity = memberRepository.findById(1L).get();
        LocalDate futureDate =
                memberEntity.getUpdatedDate().toLocalDate().plusDays(Integer.MAX_VALUE);

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/meal/" + futureDate)
                                .contentType(MediaType.APPLICATION_JSON));

        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        ApiResponse.CustomBody<GetMealFoodResponse> getMealFoodResponseCustomBody =
                om.readValue(
                        responseBody,
                        new TypeReference<ApiResponse.CustomBody<GetMealFoodResponse>>() {});
        AllAnalysisDTO allAnalysisDTO =
                getMealFoodResponseCustomBody.getResponse().allAnalysisDTO();

        List<MealRecordDTO> mealRecordDTOS =
                getMealFoodResponseCustomBody.getResponse().mealRecordDTOS();

        assertAll(
                () -> assertEquals(allAnalysisDTO.isVisited(), false),
                () -> assertTrue(mealRecordDTOS.size() == 0));
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("성공 : 회원가입한 날짜에 켈린더 상세 조회가 정상적으로 이루어져야 한다.")
    @WithMockUser(memberId = 2L)
    void when_getSpecificMeal_createdAt_expected_InValidDateFoundException() throws Exception {

        long memberId = 2L;
        MemberEntity memberEntity = memberRepository.findById(memberId).get();
        LocalDate signUpDate = memberEntity.getCreatedDate().toLocalDate();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/meal/" + signUpDate)
                                .contentType(MediaType.APPLICATION_JSON));

        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("성공 : 온보딩 혹은 회원 수정 직후 해당 온보딩 날짜에 캘린더 상세 조회가 정상적으로 이루어져야 한다.")
    @Sql("classpath:db/testData_signup_after_2days_onboarding.sql")
    @WithMockUser(memberId = 1L)
    void when_getSpecificMeal_onBoarding_completedAt__expected_success() throws Exception {
        // given
        MemberEntity memberEntity = memberRepository.findById(1L).get();
        memberEntity.updateWeight(memberEntity.getWeight(), memberEntity.getTargetWeight() + 1);
        memberRepository.save(memberEntity);
        LocalDate onboardingCompletedAt =
                memberRepository.findById(1L).get().getUpdatedDate().toLocalDate();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/meal/" + onboardingCompletedAt)
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(status().isOk());
    }

    @Test
    @DisplayName("성공 : 과거 온보딩한 날짜 조회가 정상적으로 이루어져야 한다.")
    @Sql("classpath:db/testData_signup_after_2days_onboarding.sql")
    @WithMockUser(memberId = 1L)
    void when_getSpecificMeal_onBoardingDate_expected_success() throws Exception {
        // given
        LocalDate onBoardingDate =
                memberRepository.findById(1L).get().getUpdatedDate().toLocalDate();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/meal/" + onBoardingDate)
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(status().isOk());
    }
}
