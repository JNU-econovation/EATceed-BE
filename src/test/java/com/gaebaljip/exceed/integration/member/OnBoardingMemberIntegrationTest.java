package com.gaebaljip.exceed.integration.member;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.gaebaljip.exceed.adapter.in.member.request.OnBoardingMemberRequest;
import com.gaebaljip.exceed.adapter.out.jpa.agreement.AgreementRepository;
import com.gaebaljip.exceed.adapter.out.jpa.member.MemberRepository;
import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.common.IntegrationTest;
import com.gaebaljip.exceed.common.WithMockUser;

class OnBoardingMemberIntegrationTest extends IntegrationTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private AgreementRepository agreementRepository;

    @Test
    @WithMockUser(memberId = 11)
    void when_onBoarding_expect_UpdatedMember() throws Exception {
        // given
        saveMember();

        // when

        OnBoardingMemberRequest request = getOnBoardingMemberRequest();

        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.post("/v1/members/detail")
                                .content(om.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON));

        // then

        MemberEntity member = memberRepository.findById(11L).get();
        Double height = member.getHeight();
        Double weight = member.getWeight();

        resultActions.andExpect(status().isOk());

        assertAll(
                () -> {
                    Assertions.assertThat(weight).isEqualTo(request.weight());
                    Assertions.assertThat(height).isEqualTo(request.height());
                });
    }

    private OnBoardingMemberRequest getOnBoardingMemberRequest() {
        OnBoardingMemberRequest request =
                new OnBoardingMemberRequest(
                        171.0, "MALE", 61.0, 65.0, 26, "NOT_ACTIVE", "뭐든 잘 먹습니다.");
        return request;
    }

    private MemberEntity saveMember() {
        // memberId = 11인 member 생성

        AgreementEntity agreementEntity =
                AgreementEntity.builder()
                        .isTermsServiceAgree(true)
                        .isPrivacyPolicyAgree(true)
                        .isOverAge(true)
                        .build();
        agreementRepository.save(agreementEntity);

        MemberEntity memberEntity =
                MemberEntity.builder()
                        .email("aaa@naver.com")
                        .password("aaaa1234@@")
                        .checked(false)
                        .agreementEntity(agreementEntity)
                        .build();
        memberRepository.save(memberEntity);
        return memberEntity;
    }
}
