package com.gaebaljip.exceed.adapter.in.agreement.request;

import javax.validation.constraints.NotNull;

import com.gaebaljip.exceed.common.ValidationMessage;

public record AgreePrivacyPolicyRequest(
        @NotNull(message = "개인 정보 처리방침을 " + ValidationMessage.NOT_NULL)
                Boolean isPrivacyPolicyAgree) {}
