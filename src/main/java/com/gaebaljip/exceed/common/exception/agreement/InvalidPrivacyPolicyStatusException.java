package com.gaebaljip.exceed.common.exception.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class InvalidPrivacyPolicyStatusException extends EatCeedException {
    public static EatCeedException EXCEPTION = new InvalidPrivacyPolicyStatusException();

    public InvalidPrivacyPolicyStatusException() {
        super(AgreementError.INVALID_PRIVACY_POLICY_STATUS);
    }
}
