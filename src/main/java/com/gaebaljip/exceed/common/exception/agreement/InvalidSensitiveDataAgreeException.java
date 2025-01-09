package com.gaebaljip.exceed.common.exception.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class InvalidSensitiveDataAgreeException extends EatCeedException {

    public static EatCeedException EXCEPTION = new InvalidSensitiveDataAgreeException();

    public InvalidSensitiveDataAgreeException() {
        super(AgreementError.INVALID_SENSITIVE_DATA_AGREE);
    }
}
