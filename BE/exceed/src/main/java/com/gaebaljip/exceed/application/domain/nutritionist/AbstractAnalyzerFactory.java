package com.gaebaljip.exceed.application.domain.nutritionist;

import com.gaebaljip.exceed.application.domain.meal.DailyMeal;
import com.gaebaljip.exceed.application.domain.member.Member;

public abstract class AbstractAnalyzerFactory {
    public abstract DailyMealAnalyzer createAnalyzer(DailyMeal dailyMeal, Member member);
}
