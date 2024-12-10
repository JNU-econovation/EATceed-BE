package com.gaebaljip.exceed.application.service.agreement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.port.in.agreement.AgreePrivacyPolicyUsecase;
import com.gaebaljip.exceed.application.port.out.member.MemberPort;
import com.gaebaljip.exceed.common.exception.agreement.InvalidPrivacyPolicyStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgreePrivacyPolicyService implements AgreePrivacyPolicyUsecase {
    private final MemberPort memberPort;

    @Override
    @Transactional
    public void execute(Long memberId, boolean isPrivacyPolicyAgree) {
        validatePrivacyPolicyAgree(isPrivacyPolicyAgree);
        AgreementEntity agreementEntity = memberPort.query(memberId).getAgreementEntity();
        agreementEntity.agreePrivacyPolicy(isPrivacyPolicyAgree);
    }

    private void validatePrivacyPolicyAgree(boolean isPrivacyPolicyAgree) {
        if (!isPrivacyPolicyAgree) {
            throw InvalidPrivacyPolicyStatusException.EXCEPTION;
        }
    }
}
