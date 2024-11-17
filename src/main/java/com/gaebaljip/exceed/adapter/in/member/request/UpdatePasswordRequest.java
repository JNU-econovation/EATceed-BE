package com.gaebaljip.exceed.adapter.in.member.request;

import com.gaebaljip.exceed.common.ValidationMessage;
import com.gaebaljip.exceed.common.annotation.Password;

import lombok.Builder;

public record UpdatePasswordRequest(
        @Password(message = ValidationMessage.INVALID_PASSWORD) String oldPassword,
        @Password(message = ValidationMessage.INVALID_PASSWORD) String newPassword) {
    @Builder
    public UpdatePasswordRequest {}
}
