package com.gaebaljip.exceed.common.docs.member;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.exception.member.EmailNotVerifiedException;
import com.gaebaljip.exceed.common.exception.member.MemberNotFoundException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;

@ExceptionDoc
public class FindPassword_validateEmailExceptionDocs implements SwaggerExampleExceptions {

    @ExplainError("회원이 존재하지 않을 때")
    public EatCeedException 회원이_존재하지_않을_때 = MemberNotFoundException.EXECPTION;

    @ExplainError("이메일 인증을 수행하지 않은 회원일 때")
    public EatCeedException 이메일인증을_수행하지_않고_비밀번호_변경을_시도할때 = EmailNotVerifiedException.EXECPTION;
}
