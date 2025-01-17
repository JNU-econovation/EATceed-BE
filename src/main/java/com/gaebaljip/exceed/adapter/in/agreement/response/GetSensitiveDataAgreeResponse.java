package com.gaebaljip.exceed.adapter.in.agreement.response;

public record GetSensitiveDataAgreeResponse(boolean isSensitiveDataAgree) {
    public static GetSensitiveDataAgreeResponse from(boolean isSensitiveDataAgree) {
        return new GetSensitiveDataAgreeResponse(isSensitiveDataAgree);
    }
}
