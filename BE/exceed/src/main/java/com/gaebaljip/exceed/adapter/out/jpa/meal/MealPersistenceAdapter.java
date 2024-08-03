package com.gaebaljip.exceed.adapter.out.jpa.meal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.gaebaljip.exceed.adapter.out.jpa.nutritionist.MonthlyMealPort;
import com.gaebaljip.exceed.application.domain.meal.DailyMeal;
import com.gaebaljip.exceed.application.domain.meal.Meal;
import com.gaebaljip.exceed.application.domain.meal.MealEntity;
import com.gaebaljip.exceed.application.domain.member.MemberEntity;
import com.gaebaljip.exceed.application.domain.nutritionist.MonthlyMeal;
import com.gaebaljip.exceed.application.port.out.meal.DailyMealPort;
import com.gaebaljip.exceed.application.port.out.meal.MealPort;
import com.gaebaljip.exceed.common.annotation.Timer;
import com.gaebaljip.exceed.common.dto.DailyMealDTO;
import com.gaebaljip.exceed.common.dto.MonthlyMealDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MealPersistenceAdapter implements MealPort, DailyMealPort, MonthlyMealPort {

    private final MealRepository mealRepository;
    private final MealConverter mealConverter;

    @Override
    public MealEntity command(MealEntity mealEntity) {
        return mealRepository.save(mealEntity);
    }

    @Override
    public List<Meal> query(DailyMealDTO dailyMealDTO) {
        LocalDateTime today = dailyMealDTO.date().toLocalDate().atStartOfDay();
        LocalDateTime tomorrow = today.plusDays(1);
        List<MealEntity> mealEntities =
                mealRepository.findAllTodayMeal(today, tomorrow, dailyMealDTO.memberId());
        return mealConverter.toMeals(mealEntities);
    }

    @Override
    @Timer
    public MonthlyMeal query(MonthlyMealDTO monthlyMealDTO) {
        LocalDateTime date = monthlyMealDTO.date().toLocalDate().atStartOfDay();
        LocalDateTime startOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime endOfMonth = date.with(TemporalAdjusters.firstDayOfNextMonth());

        List<MealEntity> mealEntities =
                mealRepository.findMealsByMemberAndMonth(
                        startOfMonth, endOfMonth, monthlyMealDTO.memberId());
        List<Meal> meals = mealConverter.toMeals(mealEntities);
        Map<LocalDate, DailyMeal> monthlyMeal =
                meals.stream()
                        .collect(
                                Collectors.groupingBy(
                                        meal -> meal.getMealDateTime().toLocalDate(),
                                        Collectors.collectingAndThen(
                                                Collectors.toList(), DailyMeal::new)));
        List<Meal> emptyMeal = new ArrayList<>();
        startOfMonth
                .toLocalDate()
                .datesUntil(endOfMonth.toLocalDate())
                .forEach(day -> monthlyMeal.putIfAbsent(day, new DailyMeal(emptyMeal)));
        return new MonthlyMeal(monthlyMeal);
    }

    @Override
    public List<MealEntity> findByMemberEntity(MemberEntity memberEntity) {
        return mealRepository.findByMemberEntity(memberEntity);
    }

    @Override
    public void deleteByAllByIdInQuery(List<Long> ids) {
        mealRepository.deleteByAllByIdInQuery(ids);
    }
}
