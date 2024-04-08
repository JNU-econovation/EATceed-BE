package com.gaebaljip.exceed.meal.docs;

import com.gaebaljip.exceed.common.exception.EatCeedException;
import com.gaebaljip.exceed.common.swagger.ExceptionDoc;
import com.gaebaljip.exceed.common.swagger.ExplainError;
import com.gaebaljip.exceed.common.swagger.SwaggerExampleExceptions;
import com.gaebaljip.exceed.meal.exception.InsufficientMealsException;
import com.gaebaljip.exceed.meal.exception.InvalidMultipleException;
import com.gaebaljip.exceed.meal.exception.NotSameDateException;
import com.gaebaljip.exceed.member.exception.InvalidGenderException;

@ExceptionDoc
public class GetMealExceptionDocs implements SwaggerExampleExceptions {
    @ExplainError("Daily Meal에 최소 1끼도 제공 되지 않았을 때 ")
    public EatCeedException Daily_Meal에_최소_1끼도_제공_되지_않았습니다 = InsufficientMealsException.EXECPTION;

    @ExplainError("0인분 이하거나 100인분 초과일 경우 ")
    public EatCeedException _0인분_이하거나_100인분_초과일_경우 = InvalidMultipleException.EXECPTION;

    @ExplainError("식사들의 날짜가 다를 경우")
    public EatCeedException 식사들의_날짜가_다를_경우 = NotSameDateException.EXECPTION;

    @ExplainError("성별이 0과 1이 아닐 때")
    public EatCeedException 성별이_0과_1이_아닐_때 = InvalidGenderException.EXECPTION;
}
