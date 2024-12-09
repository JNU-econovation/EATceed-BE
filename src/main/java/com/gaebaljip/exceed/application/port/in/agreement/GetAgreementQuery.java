package com.gaebaljip.exceed.application.port.in.agreement;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.common.dto.GetAgreementDTO;

@Component
public interface GetAgreementQuery {
    GetAgreementDTO execute(Long memberId);
}
