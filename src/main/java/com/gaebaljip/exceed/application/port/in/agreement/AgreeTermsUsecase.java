package com.gaebaljip.exceed.application.port.in.agreement;

import com.gaebaljip.exceed.common.annotation.UseCase;

@UseCase
public interface AgreeTermsUsecase {
    void execute(Long memberId, boolean isTermsServiceAgree);
}
