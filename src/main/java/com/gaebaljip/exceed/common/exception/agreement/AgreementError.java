package com.gaebaljip.exceed.common.exception.agreement;

import java.lang.reflect.Field;
import java.util.Objects;

import com.gaebaljip.exceed.common.Error;
import com.gaebaljip.exceed.common.exception.BaseError;
import com.gaebaljip.exceed.common.swagger.ExplainError;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AgreementError implements BaseError {
    INVALID_AGREEMENT(400, "AGREEMENT_400_1", "개인 정보 처리방침, 약관, 14세 이상은 모두 동의해야합니다."),
    INVALID_PRIVACY_POLICY_STATUS(400, "AGREEMENT_400_2", "개인 정보 처리방침을 동의해야합니다.");
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
