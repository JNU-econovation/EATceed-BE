package com.gaebaljip.exceed.application.port.out.meal;

import org.springframework.stereotype.Component;

@Component
public interface PresignedUrlPort {
    String get(Long mealId, Long memberId);

    String put(Long memberId, Long mealId, String fileName);
}
