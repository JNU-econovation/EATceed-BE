package com.gaebaljip.exceed.common.exception.member;

import com.gaebaljip.exceed.common.exception.EatCeedException;

import lombok.Getter;

@Getter
public class SamePasswordException extends EatCeedException {
    public static EatCeedException EXECPTION = new SamePasswordException();

    public SamePasswordException() {
        super(MemberError.SAME_PASSWORD);
    }
}
