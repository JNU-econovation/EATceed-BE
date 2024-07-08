package com.gaebaljip.exceed.member.adapter.in;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.dto.request.CheckMemberRequest;
import com.gaebaljip.exceed.member.application.port.in.CheckCodeUsecase;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@SecurityRequirement(name = "access-token")
@Tag(name = "[회원가입]")
public class CheckMemberEmailController {

    private final CheckCodeUsecase checkCodeUsecase;

    @GetMapping("/members/checked")
    public ApiResponse<ApiResponse.CustomBody<Void>> checkMemberEmail(
            @ModelAttribute @Valid CheckMemberRequest checkMemberRequest) {
        checkCodeUsecase.execute(checkMemberRequest);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
