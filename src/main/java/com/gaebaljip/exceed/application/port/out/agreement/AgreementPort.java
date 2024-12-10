package com.gaebaljip.exceed.application.port.out.agreement;

import java.util.Optional;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.common.annotation.Port;

@Port
public interface AgreementPort {
    AgreementEntity command(AgreementEntity agreementEntity);

    Optional<AgreementEntity> query(Long memberId);
}
