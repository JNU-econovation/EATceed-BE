package com.gaebaljip.exceed.common.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public record AnnounceDTO(
        Long announceId,
        String title,
        String content,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
                LocalDateTime createdDate) {
    public static AnnounceDTO of(
            Long announceId, String title, String content, LocalDateTime createdDate) {
        return new AnnounceDTO(announceId, title, content, createdDate);
    }
}
