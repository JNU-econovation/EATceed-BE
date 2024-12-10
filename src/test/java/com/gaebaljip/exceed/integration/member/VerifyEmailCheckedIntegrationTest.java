package com.gaebaljip.exceed.integration.member;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gaebaljip.exceed.adapter.out.jpa.agreement.AgreementRepository;
import com.gaebaljip.exceed.adapter.out.jpa.member.MemberRepository;
import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.IntegrationTest;

class VerifyEmailCheckedIntegrationTest extends IntegrationTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private AgreementRepository agreementRepository;

    @Test
    void when_emailNotChecked_expected_returnFalse() throws Exception {

        // given
        String email = "aaa@naver.com";
        saveEmailNotCheckedMember(email);

        // when
        ResultActions resultActions =
                mockMvc.perform(
                        MockMvcRequestBuilders.get("/v1/members/email/checked")
                                .param("email", email)
                                .contentType(MediaType.APPLICATION_JSON));

        // then
        resultActions.andExpect(status().isOk());
        String responseBody = resultActions.andReturn().getResponse().getContentAsString();
        ApiResponse.CustomBody<Boolean> verifyEmailChecked =
                om.readValue(responseBody, new TypeReference<ApiResponse.CustomBody<Boolean>>() {});
        Assertions.assertEquals(verifyEmailChecked.getResponse(), false);
    }

    private void saveEmailNotCheckedMember(String email) {
        AgreementEntity agreementEntity =
                AgreementEntity.builder()
                        .isTermsServiceAgree(true)
                        .isPrivacyPolicyAgree(true)
                        .isOverAge(true)
                        .build();
        agreementRepository.save(agreementEntity);

        MemberEntity memberEntity =
                MemberEntity.builder()
                        .email(email)
                        .password("aaaa1234@@")
                        .checked(false)
                        .agreementEntity(agreementEntity)
                        .build();
        memberRepository.save(memberEntity);
    }
}
