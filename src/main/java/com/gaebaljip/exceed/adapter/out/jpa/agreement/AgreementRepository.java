package com.gaebaljip.exceed.adapter.out.jpa.agreement;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;

public interface AgreementRepository extends JpaRepository<AgreementEntity, Long> {}
