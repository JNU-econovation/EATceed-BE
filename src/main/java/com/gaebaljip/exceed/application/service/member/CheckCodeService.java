package com.gaebaljip.exceed.application.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.port.in.member.CheckCodeUsecase;
import com.gaebaljip.exceed.application.port.out.member.CodePort;
import com.gaebaljip.exceed.common.exception.member.ExpiredCodeException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckCodeService implements CheckCodeUsecase {

    private final CodePort codePort;

    @Override
    @Transactional
    public void execute(String email, String rawCode) {
        String validCode = codePort.query(email).orElseThrow(() -> ExpiredCodeException.EXECPTION);
        if (!validCode.equals(rawCode)) {
            throw ExpiredCodeException.EXECPTION;
        }
    }
}
