package com.gaebaljip.exceed.common.exception.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class InvalidTermsServiceStatusException extends EatCeedException {
    public static EatCeedException EXCEPTION = new InvalidTermsServiceStatusException();

    public InvalidTermsServiceStatusException() {
        super(AgreementError.INVALID_TERMS_SERVICE_STATUS);
    }
}
