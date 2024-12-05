package com.gaebaljip.exceed.common.dto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gaebaljip.exceed.application.domain.meal.MealEntity;
import com.gaebaljip.exceed.application.domain.meal.MealType;
import com.gaebaljip.exceed.common.CustomDoubleSerializer;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

public record MealRecordDTO(
        @Schema(description = "식사 시간", pattern = "HH:mm:ss", example = "10:11")
                @JsonFormat(
                        shape = JsonFormat.Shape.STRING,
                        pattern = "HH:mm",
                        timezone = "Asia/Seoul")
                LocalTime time,
        MealType mealType,
        @JsonSerialize(using = CustomDoubleSerializer.class) Double totalCalories,
        String imageUri,
        List<FoodDTO> foodDTOS) {
    public static MealRecordDTO of(MealEntity mealEntity, String imageUri) {
        return MealRecordDTO.builder()
                .mealType(mealEntity.getMealType())
                .time(mealEntity.getCreatedDate().toLocalTime())
                .imageUri(imageUri)
                .totalCalories(
                        mealEntity.getMealFoodEntities().stream()
                                .mapToDouble(mealFood -> mealFood.getAdjustedCalorie())
                                .sum())
                .foodDTOS(
                        mealEntity.getMealFoodEntities().stream()
                                .map(
                                        mealFood ->
                                                FoodDTO.builder()
                                                        .id(mealFood.getFoodEntity().getId())
                                                        .name(mealFood.getFoodEntity().getName())
                                                        .build())
                                .collect(Collectors.toList()))
                .build();
    }

    @Builder
    public MealRecordDTO {}
}
