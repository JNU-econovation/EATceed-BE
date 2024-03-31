package com.gaebaljip.exceed.member.application;

import com.gaebaljip.exceed.member.adapter.out.persistence.MemberEntity;
import com.gaebaljip.exceed.member.application.port.in.OnBoardingMemberCommand;
import com.gaebaljip.exceed.member.application.port.in.OnBoardingMemberUsecase;
import com.gaebaljip.exceed.member.application.port.out.MemberPort;
import com.gaebaljip.exceed.member.exception.InvalidAgeException;
import com.gaebaljip.exceed.member.exception.InvalidGenderException;
import com.gaebaljip.exceed.member.exception.InvalidHeightException;
import com.gaebaljip.exceed.member.exception.InvalidWeightException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OnBoardingMemberService implements OnBoardingMemberUsecase {

    public static final int MINIMUM_HEIGHT = 0;
    public static final int MINIMUM_WEIGHT = 0;
    public static final int MINIMUM_AGE = 0;

    private final MemberPort memberPort;

    @Override
    @Transactional
    public void execute(OnBoardingMemberCommand command) {
        validateCommand(command);
        MemberEntity memberEntity = memberPort.query(command.memberId());
        memberEntity.updateMember(command.height(),command.gender(),command.age(),command.activity(),command.etc(), command.weight(), command.targetWeight());
    }

    private void validateCommand(OnBoardingMemberCommand command) {
        validateHeight(command.height());
        validateWeight(command.weight());
        validateTargetWeight(command.targetWeight());
        validateAge(command.age());
        validGender(command.gender());
    }

    private void validGender(Integer gender) {
        if (gender < 0 || gender > 1) {
            throw new InvalidGenderException();
        }
    }

    private void validateHeight(Double height) {
        if (height <= MINIMUM_HEIGHT) {
            throw new InvalidHeightException();
        }
    }

    private void validateWeight(Double weight) {
        if (weight <= MINIMUM_WEIGHT) {
            throw new InvalidWeightException();
        }
    }

    private void validateTargetWeight(Double targetWeight) {
        if (targetWeight <= MINIMUM_WEIGHT) {
            throw new InvalidWeightException();
        }
    }

    private void validateAge(Integer age) {
        if (age <= MINIMUM_AGE) {
            throw new InvalidAgeException();
        }
    }
}
