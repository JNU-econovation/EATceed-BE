package com.gaebaljip.exceed.common.docs.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.exception.agreement.InvalidSensitiveDataAgreeException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;

@ExceptionDoc
public class AgreeSensitiveDataDocs implements SwaggerExampleExceptions {
    @ExplainError("민감 정보 수집을_수락하지_않을_때")
    public EatCeedException 민감정보_수집을_수락하지_않을_때 = InvalidSensitiveDataAgreeException.EXCEPTION;
}
