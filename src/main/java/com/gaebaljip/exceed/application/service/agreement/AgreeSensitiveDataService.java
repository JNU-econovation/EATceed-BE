package com.gaebaljip.exceed.application.service.agreement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.port.in.agreement.AgreeSensitiveDataUsecase;
import com.gaebaljip.exceed.application.port.out.agreement.AgreementPort;
import com.gaebaljip.exceed.common.exception.agreement.AgreementNotFoundException;
import com.gaebaljip.exceed.common.exception.agreement.InvalidSensitiveDataAgreeException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgreeSensitiveDataService implements AgreeSensitiveDataUsecase {
    private final AgreementPort agreementPort;

    @Override
    @Transactional
    public void execute(Long memberId, boolean isSensitiveDataAgree) {
        validateSensitiveDataAgree(isSensitiveDataAgree);
        AgreementEntity agreementEntity =
                agreementPort.query(memberId).orElseThrow(AgreementNotFoundException::new);
        agreementEntity.agreeSensitiveData(isSensitiveDataAgree);
    }

    private void validateSensitiveDataAgree(boolean isSensitiveDataAgree) {
        if (!isSensitiveDataAgree) {
            throw InvalidSensitiveDataAgreeException.EXCEPTION;
        }
    }
}
