package com.gaebaljip.exceed.adapter.in.member.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.gaebaljip.exceed.common.ValidationMessage;

import lombok.Builder;

public record CheckMemberRequest(
        @Email(message = ValidationMessage.INVALID_EMAIL)
                @NotEmpty(message = "이메일을 " + ValidationMessage.NOT_EMPTY)
                String email,
        @NotBlank(message = "코드를 " + ValidationMessage.NOT_NULL) String code) {
    @Builder
    public CheckMemberRequest {}
}
