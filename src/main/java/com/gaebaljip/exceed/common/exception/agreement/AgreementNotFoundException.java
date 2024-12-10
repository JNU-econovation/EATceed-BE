package com.gaebaljip.exceed.common.exception.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class AgreementNotFoundException extends EatCeedException {
    public static EatCeedException EXCEPTION = new AgreementNotFoundException();

    public AgreementNotFoundException() {
        super(AgreementError.AGREEMENT_NOT_FOUND);
    }
}
