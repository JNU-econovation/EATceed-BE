package com.gaebaljip.exceed.adapter.out.jpa.agreement;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.port.out.agreement.AgreementPort;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgreementPersistenceAdapter implements AgreementPort {

    private final AgreementRepository agreementRepository;

    @Override
    public AgreementEntity command(AgreementEntity agreementEntity) {
        return agreementRepository.save(agreementEntity);
    }

    @Override
    public Optional<AgreementEntity> query(Long memberId) {
        return Optional.ofNullable(agreementRepository.findByMemberId(memberId));
    }
}
