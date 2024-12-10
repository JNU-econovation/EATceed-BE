package com.gaebaljip.exceed.adapter.in.agreement.response;

public record GetPrivacyPolicyResponse(boolean isPrivacyPolicyAgree) {
    public static GetPrivacyPolicyResponse from(boolean isPrivacyPolicyAgree) {
        return new GetPrivacyPolicyResponse(isPrivacyPolicyAgree);
    }
}
