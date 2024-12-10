package com.gaebaljip.exceed.adapter.out.jpa.agreement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gaebaljip.exceed.application.domain.agreement.AgreementEntity;

public interface AgreementRepository extends JpaRepository<AgreementEntity, Long> {

    @Query("select a from MemberEntity m join m.agreementEntity a where m.id = :memberId")
    AgreementEntity findByMemberId(@Param("memberId") Long memberId);
}
