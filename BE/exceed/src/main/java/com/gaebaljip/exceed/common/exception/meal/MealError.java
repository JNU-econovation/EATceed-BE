package com.gaebaljip.exceed.common.exception.meal;

import java.lang.reflect.Field;
import java.util.Objects;

import com.gaebaljip.exceed.common.Error;
import com.gaebaljip.exceed.common.exception.BaseError;
import com.gaebaljip.exceed.common.swagger.ExplainError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum MealError implements BaseError {
    EXTENTION_NOT_ALLOWED(400, "4452", "이미지의 확장자는 jpg, jpeg, png만 가능합니다."),
    INSUFFICIENT_MEALS(400, "6000", "하루 식사는 최소 한 끼 이상 제공되어야 합니다."),
    INVALID_MULTIPLE(400, "4449", "0인분보다 커야하고, 100인분보다 작아야합니다."),
    NOT_SAME_DATE(400, "6001", "하루 식사는 같은 날짜입니다."),
    INVALID_MULTIPLE_AND_G(
            400,
            "6002",
            "'multiple'은 null이 아니고 'g'는 null이어야 하거나, 'multiple'은 null이고 'g'는 null이 아니어야 합니다."),
    INVALID_G(400, "6002", "g은 1 이상이어야합니다."),
    INVALID_DATE_FOUND(400, "6321", "회원가입 이전의 기록은 없습니다.");

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
