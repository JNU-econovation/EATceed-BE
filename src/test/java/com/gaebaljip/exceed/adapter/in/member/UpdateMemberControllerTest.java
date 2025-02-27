package com.gaebaljip.exceed.adapter.in.member;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import com.gaebaljip.exceed.adapter.in.member.request.UpdateMemberRequest;
import com.gaebaljip.exceed.common.ControllerTest;
import com.gaebaljip.exceed.common.ValidationMessage;
import com.gaebaljip.exceed.common.WithMockUser;

public class UpdateMemberControllerTest extends ControllerTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "  ", "매운 거 못 먹음"})
    @DisplayName("회원 수정 성공")
    @WithMockUser
    void when_updateMember_expected_success(String etc) throws Exception {
        // given
        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(180.3)
                        .activity("VERY_ACTIVE")
                        .age(40)
                        .gender("MALE")
                        .etc(etc)
                        .build();
        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("회원 수정 실패 - 키를 입력하지 않은 경우")
    @WithMockUser
    void when_updateMember_height_null_expected_exception() throws Exception {
        // given
        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(null)
                        .activity("VERY_ACTIVE")
                        .age(40)
                        .gender("MALE")
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value("키를 " + ValidationMessage.NOT_NULL));
    }

    @Test
    @DisplayName("회원 수정 실패 - 키가 0보다 작은 경우")
    @WithMockUser
    void when_updateMember_height_negative_expected_exception() throws Exception {
        // given
        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(-1.0)
                        .activity("VERY_ACTIVE")
                        .age(40)
                        .gender("MALE")
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value("키는 " + ValidationMessage.MIN_0));
    }

    @Test
    @DisplayName("회원 수정 실패 - 나이를 입력하지 않은 경우")
    @WithMockUser
    void when_updateMember_age_null_expected_exception() throws Exception {
        // given
        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(180.3)
                        .activity("VERY_ACTIVE")
                        .age(null)
                        .gender("MALE")
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value("나이를 " + ValidationMessage.NOT_NULL));
    }

    @Test
    @DisplayName("회원 수정 실패 - 나이가 0보다 작은 경우")
    @WithMockUser
    void when_updateMember_age_negative_expected_exception() throws Exception {
        // given
        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(180.3)
                        .activity("VERY_ACTIVE")
                        .age(-1)
                        .gender("MALE")
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value("나이는 " + ValidationMessage.MIN_0));
    }

    @Test
    @DisplayName("회원 수정 실패 - 성별이 올바르지 않은 경우")
    @WithMockUser
    void when_updateMember_gender_invalid_expected_exception() throws Exception {
        // given
        String gender = "MALLY";

        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(180.3)
                        .activity("VERY_ACTIVE")
                        .age(40)
                        .gender(gender)
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value(gender + "는 올바르지 않은 값입니다."));
    }

    @Test
    @DisplayName("회원 수정 실패 - 활동량이 올바르지 않은 경우")
    @WithMockUser
    void when_updateMember_activity_invalid_expected_exception() throws Exception {
        // given
        String activity = "INVALID";

        UpdateMemberRequest updateMemberRequest =
                UpdateMemberRequest.builder()
                        .height(180.3)
                        .activity(activity)
                        .age(40)
                        .gender("MALE")
                        .etc("회원 수정")
                        .build();

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        put("/v1/members")
                                .content(om.writeValueAsString(updateMemberRequest))
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.reason").value(activity + "는 올바르지 않은 값입니다."));
    }
}
