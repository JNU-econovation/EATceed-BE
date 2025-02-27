package com.gaebaljip.exceed.application.service.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.adapter.in.member.request.SignUpMemberRequest;
import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.port.in.member.CreateMemberUsecase;
import com.gaebaljip.exceed.application.port.out.agreement.AgreementPort;
import com.gaebaljip.exceed.application.port.out.member.MemberPort;
import com.gaebaljip.exceed.common.annotation.EventPublisherStatus;
import com.gaebaljip.exceed.common.event.Events;
import com.gaebaljip.exceed.common.event.SignUpMemberEvent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateMemberService implements CreateMemberUsecase {

    private final MemberPort memberPort;
    private final AgreementPort agreementPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    @EventPublisherStatus
    public void execute(SignUpMemberRequest signUpMemberRequest) {
        if (!memberPort.existsByEmail(signUpMemberRequest.email())) {
            AgreementEntity agreementEntity =
                    AgreementEntity.createAgreement(
                            signUpMemberRequest.isPrivacyPolicyAgree(),
                            signUpMemberRequest.isTermsServiceAgree(),
                            signUpMemberRequest.isOverAge(),
                            signUpMemberRequest.isSensitiveDataAgree());
            agreementPort.command(agreementEntity);
            MemberEntity memberEntity =
                    MemberEntity.createMember(
                            signUpMemberRequest.email(),
                            bCryptPasswordEncoder.encode(signUpMemberRequest.password()),
                            agreementEntity);
            memberPort.command(memberEntity);
            Events.raise(SignUpMemberEvent.from(signUpMemberRequest.email()));
        }
    }
}
