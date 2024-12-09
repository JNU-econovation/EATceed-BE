package com.gaebaljip.exceed.common.exception.announce;

import com.gaebaljip.exceed.common.exception.EatCeedException;

public class AnnounceNotFoundException extends EatCeedException {

    public static EatCeedException EXECPTION = new AnnounceNotFoundException();

    private AnnounceNotFoundException() {
        super(AnnounceError.INVALID_ANNOUNCE);
    }
}
