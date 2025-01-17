package com.gaebaljip.exceed.adapter.in.agreement.request;

import javax.validation.constraints.NotNull;

import com.gaebaljip.exceed.common.ValidationMessage;

public record AgreeSensitiveDataRequest(
        @NotNull(message = "민감 정보를 " + ValidationMessage.NOT_NULL) Boolean isSensitiveDataAgree) {}
