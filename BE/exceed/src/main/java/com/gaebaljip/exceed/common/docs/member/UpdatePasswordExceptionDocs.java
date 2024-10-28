package com.gaebaljip.exceed.common.docs.member;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.exception.auth.PasswordMismatchException;
import com.gaebaljip.exceed.common.exception.member.SamePasswordException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;

@ExceptionDoc
public class UpdatePasswordExceptionDocs implements SwaggerExampleExceptions {

    @ExplainError("기존 비밀번호가 잘못된 비밀번호일 경우")
    public EatCeedException 기존_비밀번호가_잘못된_비밀번호일_경우 = PasswordMismatchException.EXECPTION;

    @ExplainError("바꾸려는 비밀번호가 기존 비밀번호와 같을 경우")
    public EatCeedException 바꾸려는_비밀번호가_기존_비밀번호와_같을_경우 = SamePasswordException.EXECPTION;
}
