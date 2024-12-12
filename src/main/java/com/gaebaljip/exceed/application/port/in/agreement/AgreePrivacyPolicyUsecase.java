package com.gaebaljip.exceed.application.port.in.agreement;

import com.gaebaljip.exceed.common.annotation.UseCase;

@UseCase
public interface AgreePrivacyPolicyUsecase {
    void execute(Long memberId, boolean isPrivacyPolicyAgree);
}
