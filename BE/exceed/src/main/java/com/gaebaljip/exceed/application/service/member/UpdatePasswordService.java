package com.gaebaljip.exceed.application.service.member;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.port.in.member.UpdatePasswordUsecase;
import com.gaebaljip.exceed.application.port.out.member.MemberPort;
import com.gaebaljip.exceed.common.exception.auth.PasswordMismatchException;
import com.gaebaljip.exceed.common.exception.member.SamePasswordException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdatePasswordService implements UpdatePasswordUsecase {

    private final MemberPort memberPort;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void execute(String email, String password) {
        MemberEntity member = memberPort.findMemberByEmail(email);
        member.updatePassword(bCryptPasswordEncoder.encode(password));
    }

    @Override
    public void execute(Long memberId, String oldPassword, String newPassword) {
        MemberEntity member = memberPort.query(memberId);
        String originPassword = member.getPassword();
        validateOldPasswordMatch(oldPassword, originPassword);
        validatePasswordIsSame(oldPassword, newPassword);
        member.updatePassword(bCryptPasswordEncoder.encode(newPassword));
    }

    private void validateOldPasswordMatch(String oldPassword, String originPassword) {
        if (!bCryptPasswordEncoder.matches(oldPassword, originPassword)) {
            throw PasswordMismatchException.EXECPTION;
        }
    }

    public void validatePasswordIsSame(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            throw SamePasswordException.EXECPTION;
        }
    }
}
