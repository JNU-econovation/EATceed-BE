package com.gaebaljip.exceed.common.docs.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.exception.agreement.InvalidTermsServiceStatusException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;

@ExceptionDoc
public class AgreeTermsServiceDocs implements SwaggerExampleExceptions {
    @ExplainError("약관을_수락하지_않을_때")
    public EatCeedException 약관을_수락하지_않을_때 = InvalidTermsServiceStatusException.EXCEPTION;
}
