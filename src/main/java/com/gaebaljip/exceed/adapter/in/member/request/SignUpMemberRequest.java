package com.gaebaljip.exceed.adapter.in.member.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.gaebaljip.exceed.common.ValidationMessage;
import com.gaebaljip.exceed.common.annotation.Password;

import lombok.Builder;

public record SignUpMemberRequest(
        @Email(message = ValidationMessage.INVALID_EMAIL)
                @NotEmpty(message = "이메일을 " + ValidationMessage.NOT_EMPTY)
                String email,
        @Password(message = ValidationMessage.INVALID_PASSWORD) String password,
        @NotNull(message = "약관 확인 여부를 " + ValidationMessage.NOT_NULL) Boolean isPrivacyPolicyAgree,
        @NotNull(message = "개인 정보 처리방침 확인 여부를 " + ValidationMessage.NOT_NULL)
                Boolean isTermsServiceAgree,
        @NotNull(message = "만 14세 이상 여부를 " + ValidationMessage.NOT_NULL) Boolean isOverAge,
        @NotNull(message = "민감 정보 동의 여부를 " + ValidationMessage.NOT_NULL)
                Boolean isSensitiveDataAgree) {

    @Builder
    public SignUpMemberRequest {}
}
