package com.gaebaljip.exceed.common.dto;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;

public record GetAgreementDTO(
        boolean isPrivacyPolicyAgree, boolean isTermsServiceAgree, boolean isOverAge) {
    public static GetAgreementDTO of(AgreementEntity agreementEntity) {
        return new GetAgreementDTO(
                agreementEntity.getIsPrivacyPolicyAgree(),
                agreementEntity.getIsTermsServiceAgree(),
                agreementEntity.getIsOverAge());
    }
}
