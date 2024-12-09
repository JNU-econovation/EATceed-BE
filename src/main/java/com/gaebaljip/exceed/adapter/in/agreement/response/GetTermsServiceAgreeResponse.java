package com.gaebaljip.exceed.adapter.in.agreement.response;

public record GetTermsServiceAgreeResponse(boolean isTermsServiceAgree) {
    public static GetTermsServiceAgreeResponse from(boolean isTermsServiceAgree) {
        return new GetTermsServiceAgreeResponse(isTermsServiceAgree);
    }
}
