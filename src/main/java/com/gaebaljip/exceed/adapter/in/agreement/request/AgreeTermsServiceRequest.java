package com.gaebaljip.exceed.adapter.in.agreement.request;

import javax.validation.constraints.NotNull;

import com.gaebaljip.exceed.common.ValidationMessage;

public record AgreeTermsServiceRequest(
        @NotNull(message = "약관을 " + ValidationMessage.NOT_NULL) Boolean isTermsServiceAgree) {}
