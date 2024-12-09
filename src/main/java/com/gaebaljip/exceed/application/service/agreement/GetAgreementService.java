package com.gaebaljip.exceed.application.service.agreement;

import org.springframework.stereotype.Service;

import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.port.in.agreement.GetAgreementQuery;
import com.gaebaljip.exceed.application.port.out.member.MemberPort;
import com.gaebaljip.exceed.common.dto.GetAgreementDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetAgreementService implements GetAgreementQuery {
    private final MemberPort memberPort;

    @Override
    public GetAgreementDTO execute(Long memberId) {
        MemberEntity memberEntity = memberPort.query(memberId);
        return GetAgreementDTO.of(memberEntity.getAgreementEntity());
    }
}
