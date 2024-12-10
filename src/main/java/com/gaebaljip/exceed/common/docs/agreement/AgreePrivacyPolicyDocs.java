package com.gaebaljip.exceed.common.docs.agreement;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.exception.agreement.InvalidPrivacyPolicyStatusException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;

@ExceptionDoc
public class AgreePrivacyPolicyDocs implements SwaggerExampleExceptions {
    @ExplainError("개인정보처리방침을_수락하지_않을_때")
    public EatCeedException 개인정보처리방침을_수락하지_않을_때 = InvalidPrivacyPolicyStatusException.EXCEPTION;
}
