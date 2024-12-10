package com.gaebaljip.exceed.application.service.agreement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.port.in.agreement.AgreeTermsUsecase;
import com.gaebaljip.exceed.application.port.out.member.MemberPort;
import com.gaebaljip.exceed.common.exception.agreement.InvalidTermsServiceStatusException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgreeTermsService implements AgreeTermsUsecase {
    private final MemberPort memberPort;

    @Override
    @Transactional
    public void execute(Long memberId, boolean isTermsServiceAgree) {
        MemberEntity memberEntity = memberPort.query(memberId);
        validateTermsAgree(isTermsServiceAgree);
        memberEntity.getAgreementEntity().agreeTermsService(isTermsServiceAgree);
    }

    private void validateTermsAgree(boolean isTermsServiceAgree) {
        if (!isTermsServiceAgree) {
            throw InvalidTermsServiceStatusException.EXCEPTION;
        }
    }
}
