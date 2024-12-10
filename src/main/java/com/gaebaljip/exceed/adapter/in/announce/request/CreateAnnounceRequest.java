package com.gaebaljip.exceed.adapter.in.announce.request;

import javax.validation.constraints.NotBlank;

import com.gaebaljip.exceed.common.ValidationMessage;

public record CreateAnnounceRequest(
        @NotBlank(message = "제목을 " + ValidationMessage.NOT_BLANK) String title,
        @NotBlank(message = "내용을 " + ValidationMessage.NOT_BLANK) String content) {}
