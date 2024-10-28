package com.gaebaljip.exceed.integration.member;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.gaebaljip.exceed.common.exception.auth.AuthError;
import com.gaebaljip.exceed.common.exception.member.MemberError;

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

    @Test
    @DisplayName("비밀번호 변경 실패 - 바꾸려는 비밀번호와 기존 비밀번호가 같을 경우")
    @WithMockUser
    void when_updatePassword_expected_fail_1() throws Exception {
        // given

        Long memberId = 1L;
        String oldPassword = "Abc@123";
        String newPassword = "Abc@123";
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

        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.code").value(MemberError.SAME_PASSWORD.getCode()));
    }

    @Test
    @DisplayName("비밀번호 변경 실패 - 본인 확인용으로 작성한 비밀번호가 실제 비밀번호와 다를 경우")
    @WithMockUser
    void when_updatePassword_expected_fail_2() throws Exception {
        // given

        Long memberId = 1L;
        String InvalidOldPassword = "Abc@000";
        String newPassword = "Abcd@1234";
        UpdatePasswordRequest updatePasswordRequest =
                UpdatePasswordRequest.builder()
                        .oldPassword(InvalidOldPassword)
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

        resultActions.andExpectAll(
                status().isBadRequest(),
                jsonPath("$.error.code").value(AuthError.PASSWORD_MISMATCH.getCode()));
    }
}
