package com.gaebaljip.exceed.adapter.in.member.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.gaebaljip.exceed.common.ValidationMessage;
import com.gaebaljip.exceed.common.annotation.Password;

import lombok.Builder;

public record FindPasswordRequest(
        @Email(message = ValidationMessage.INVALID_EMAIL)
                @NotEmpty(message = "이메일을 " + ValidationMessage.NOT_EMPTY)
                String email,
        @Password(message = ValidationMessage.INVALID_PASSWORD) String newPassword,
        @NotBlank(message = "인증 코드를 " + ValidationMessage.NOT_BLANK) String code) {

    @Builder
    public FindPasswordRequest {}
}
