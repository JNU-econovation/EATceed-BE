package com.gaebaljip.exceed.application.service.agreement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.port.in.agreement.AgreePrivacyPolicyUsecase;
import com.gaebaljip.exceed.application.port.out.agreement.AgreementPort;
import com.gaebaljip.exceed.common.exception.agreement.AgreementNotFoundException;
import com.gaebaljip.exceed.common.exception.agreement.InvalidPrivacyPolicyStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgreePrivacyPolicyService implements AgreePrivacyPolicyUsecase {
    private final AgreementPort agreementPort;

    @Override
    @Transactional
    public void execute(Long memberId, boolean isPrivacyPolicyAgree) {
        validatePrivacyPolicyAgree(isPrivacyPolicyAgree);
        AgreementEntity agreementEntity =
                agreementPort.query(memberId).orElseThrow(AgreementNotFoundException::new);
        agreementEntity.agreePrivacyPolicy(isPrivacyPolicyAgree);
    }

    private void validatePrivacyPolicyAgree(boolean isPrivacyPolicyAgree) {
        if (!isPrivacyPolicyAgree) {
            throw InvalidPrivacyPolicyStatusException.EXCEPTION;
        }
    }
}
