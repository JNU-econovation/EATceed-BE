package com.gaebaljip.exceed.integration.member;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.ResultActions;

import com.gaebaljip.exceed.adapter.in.member.request.UpdatePasswordRequest;
import com.gaebaljip.exceed.adapter.out.jpa.member.MemberRepository;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.common.IntegrationTest;
import com.gaebaljip.exceed.common.WithMockUser;

public class UpdatePasswordIntegrationTest extends IntegrationTest {

    @Autowired private MemberRepository memberRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    @DisplayName("비밀번호 변경 성공")
    @WithMockUser(memberId = 1L)
    void when_updatePassword_expected_success() throws Exception {

        // given

        Long memberId = 1L;
        String oldPassword = "Abc@123";
        String newPassword = "Abcd@1234";
        UpdatePasswordRequest updatePasswordRequest =
                UpdatePasswordRequest.builder()
                        .oldPassword(oldPassword)
                        .newPassword(newPassword)
                        .build();

        // when

        ResultActions resultActions =
                mockMvc.perform(
                        patch("/v1/members/password")
                                .content(om.writeValueAsString(updatePasswordRequest))
                                .contentType(MediaType.APPLICATION_JSON));
        MemberEntity memberEntity = memberRepository.findById(1L).get();

        // then

        assertTrue(bCryptPasswordEncoder.matches(newPassword, memberEntity.getPassword()));
    }
}
