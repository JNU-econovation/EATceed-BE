package com.gaebaljip.exceed.adapter.in.auth.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.gaebaljip.exceed.common.ValidationMessage;
import com.gaebaljip.exceed.common.annotation.Password;

import lombok.Builder;

public record LoginRequest(
        @Email(message = ValidationMessage.INVALID_EMAIL)
                @NotEmpty(message = "이메일을 " + ValidationMessage.NOT_EMPTY)
                String email,
        @Password(message = ValidationMessage.INVALID_PASSWORD) String password) {
    @Builder
    public LoginRequest {}
}
