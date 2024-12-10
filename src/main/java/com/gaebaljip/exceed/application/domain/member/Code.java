package com.gaebaljip.exceed.application.domain.member;

import java.util.concurrent.ThreadLocalRandom;

public class Code {
    public static final int START = 100000;
    public static final int END = 1000000;

    public int createRandom() {
        return ThreadLocalRandom.current().nextInt(START, END);
    }
}
