package com.gaebaljip.exceed.application.domain.agreement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.gaebaljip.exceed.common.BaseEntity;
import com.gaebaljip.exceed.common.exception.agreement.InvalidAgreementException;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = AgreementEntity.ENTITY_PREFIX + "_TB")
public class AgreementEntity extends BaseEntity {
    public static final String ENTITY_PREFIX = "AGREEMENT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ENTITY_PREFIX + "_PK", nullable = false)
    private Long id;

    @Column(
            name = ENTITY_PREFIX + "_IS_PRIVACY_POLICY_AGREE",
            columnDefinition = "tinyint",
            nullable = false)
    private Boolean isPrivacyPolicyAgree = true;

    @Column(
            name = ENTITY_PREFIX + "_IS_TERMS_SERVICE_AGREE",
            columnDefinition = "tinyint",
            nullable = false)
    private Boolean isTermsServiceAgree = true;

    @Column(name = ENTITY_PREFIX + "_IS_OVER_AGE", columnDefinition = "tinyint", nullable = false)
    private Boolean isOverAge = true;

    @Column(
            name = ENTITY_PREFIX + "_IS_SENSITIVE_DATA_AGREE",
            columnDefinition = "tinyint",
            nullable = false)
    private Boolean isSensitiveDataAgree = true;

    @Builder
    private AgreementEntity(
            Boolean isPrivacyPolicyAgree, Boolean isTermsServiceAgree, Boolean isOverAge) {
        validateAgreement(isPrivacyPolicyAgree, isTermsServiceAgree, isOverAge);
        this.isPrivacyPolicyAgree = isPrivacyPolicyAgree;
        this.isTermsServiceAgree = isTermsServiceAgree;
        this.isOverAge = isOverAge;
    }

    private void validateAgreement(
            Boolean isPrivacyPolicyAgree, Boolean isTermsServiceAgree, Boolean isOverAge) {
        if (!isPrivacyPolicyAgree && isTermsServiceAgree && isOverAge) {
            throw InvalidAgreementException.EXCEPTION;
        }
    }

    public static AgreementEntity createAgreement(
            Boolean isPrivacyPolicyAgree, Boolean isTermsServiceAgree, Boolean isOverAge) {
        return AgreementEntity.builder()
                .isPrivacyPolicyAgree(isPrivacyPolicyAgree)
                .isTermsServiceAgree(isTermsServiceAgree)
                .isOverAge(isOverAge)
                .build();
    }

    public void agreePrivacyPolicy(boolean isPrivacyPolicyAgree) {
        this.isPrivacyPolicyAgree = isPrivacyPolicyAgree;
    }

    public void agreeTermsService(boolean isTermsServiceAgree) {
        this.isTermsServiceAgree = isTermsServiceAgree;
    }
}
