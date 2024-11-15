package com.gaebaljip.exceed.adapter.in.member.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.gaebaljip.exceed.common.ValidationMessage;

import lombok.Builder;

public record UpdateWeightRequest(
        @NotNull(message = "몸무게를 " + ValidationMessage.NOT_NULL)
                @Min(value = 0, message = "몸무게는 " + ValidationMessage.MIN_0)
                Double weight,
        @NotNull(message = "목표 몸무게를 " + ValidationMessage.NOT_NULL)
                @Min(value = 0, message = "목표 몸무게는 " + ValidationMessage.MIN_0)
                Double targetWeight) {
    @Builder
    public UpdateWeightRequest {}
}
