package com.gaebaljip.exceed.common.exception.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class InvalidAgreementException extends EatCeedException {
    public static EatCeedException EXCEPTION = new InvalidAgreementException();

    public InvalidAgreementException() {
        super(AgreementError.INVALID_AGREEMENT);
    }
}
