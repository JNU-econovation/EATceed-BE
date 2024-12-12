package com.gaebaljip.exceed.adapter.in.announce;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.adapter.in.announce.response.GetAnnounceResponse;
import com.gaebaljip.exceed.application.port.in.announce.GetAnnounceQuery;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.docs.SwaggerTag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@SecurityRequirement(name = "access-token")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
@Tag(name = SwaggerTag.ANNOUNCE)
public class GetAnnounceController {
    private final GetAnnounceQuery getAnnounceQuery;

    @Operation(summary = "공지사항 전체 조회", description = "공지사항 전체 조회")
    @GetMapping("/announce")
    public ApiResponse<CustomBody<GetAnnounceResponse>> getAnnounce() {
        return ApiResponseGenerator.success(getAnnounceQuery.execute(), HttpStatus.OK);
    }
}
