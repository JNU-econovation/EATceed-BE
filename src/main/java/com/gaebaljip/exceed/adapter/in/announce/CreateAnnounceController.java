package com.gaebaljip.exceed.adapter.in.announce;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.adapter.in.announce.request.CreateAnnounceRequest;
import com.gaebaljip.exceed.application.port.in.announce.CreateAnnounceUseCase;
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
public class CreateAnnounceController {
    private final CreateAnnounceUseCase createAnnounceUseCase;

    @Operation(summary = "공지사항 작성", description = "공지사항 작성")
    @PostMapping("/announce")
    public ApiResponse<CustomBody<Void>> createAnnounce(
            @RequestBody @Valid CreateAnnounceRequest request) {
        createAnnounceUseCase.execute(request);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
