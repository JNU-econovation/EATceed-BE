package com.gaebaljip.exceed.common.exception.member;

import java.lang.reflect.Field;
import java.util.Objects;

import com.gaebaljip.exceed.common.Error;
import com.gaebaljip.exceed.common.exception.BaseError;
import com.gaebaljip.exceed.common.swagger.ExplainError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MemberError implements BaseError {
    ALREADY_SIGN_UP_MEMBER(400, "MEMBER_400_1", "이미 회원가입이 된 이메일입니다."),
    ALREADY_EMAIL(400, "MEMBER_400_2", "이메일 인증을 하지 않은 회원입니다."),
    INVALID_AGE(400, "MEMBER_400_3", "나이는 음수일 수 없습니다."),
    INVALID_CODE(400, "MEMBER_400_4", "올바르지 않은 인증 코드이거나 만료된 인증코드입니다. 이메일 재전송을 해주세요."),
    INVALID_GENDER(400, "MEMBER_400_5", "성별은 1과 0으로만 표현됩니다."),
    INVALID_HEIGHT(400, "MEMBER_400_6", "키는 음수일 수 없습니다."),
    INVALID_WEIGHT(400, "MEMBER_400_7", "몸무게가 음수일 수 없습니다."),
    MAIL_SEND_FAIL(400, "MEMBER_400_8", "메일 전송에 실패하였습니다."),
    INVALID_MEMBER(400, "MEMBER_400_9", "존재하지 않는 회원입니다."),
    HISTORY_NOT_FOUND(500, "MEMBER_500_1", "첫 온보딩하기 전입니다."),
    SAME_PASSWORD(400, "MEMBER_400_10", "바꾸려는 비밀번호가 기존 비밀번호와 같아서 변경할 수 없습니다.");
    private final Integer status;
    private final String code;
    private final String reason;

    @Override
    public Error getError() {
        return Error.builder().reason(reason).code(code).status(status.toString()).build();
    }

    @Override
    public String getExplainError() throws NoSuchFieldException {
        Field field = this.getClass().getField(this.name());
        ExplainError annotation = field.getAnnotation(ExplainError.class);
        return Objects.nonNull(annotation) ? annotation.value() : this.getReason();
    }
}
