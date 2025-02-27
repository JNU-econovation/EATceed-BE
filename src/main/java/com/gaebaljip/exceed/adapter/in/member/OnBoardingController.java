package com.gaebaljip.exceed.adapter.in.member;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.gaebaljip.exceed.adapter.in.member.request.OnBoardingMemberRequest;
import com.gaebaljip.exceed.application.port.in.member.OnBoardingMemberCommand;
import com.gaebaljip.exceed.application.port.in.member.OnBoardingMemberQuery;
import com.gaebaljip.exceed.application.port.in.member.OnBoardingMemberUsecase;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.annotation.AuthenticationMemberId;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.docs.member.OnBoardingMemberExceptionDocs;
import com.gaebaljip.exceed.common.swagger.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@SecurityRequirement(name = "access-token")
@Tag(name = SwaggerTag.ONBOARDING)
public class OnBoardingController {

    private final OnBoardingMemberUsecase onBoardingMemberUsecase;

    @Operation(summary = "회원 정보 온보딩", description = "회원 정보를 온보딩한다.")
    @PostMapping("/members/detail")
    @ApiErrorExceptionsExample(OnBoardingMemberExceptionDocs.class)
    public ApiResponse<CustomBody<Void>> onBoardingMember(
            @RequestBody @Valid OnBoardingMemberRequest request,
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        OnBoardingMemberCommand command = OnBoardingMemberCommand.of(memberId, request);
        onBoardingMemberUsecase.execute(command);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @Operation(summary = "온보딩 여부 확인", description = "온보딩의 여부를 확인한다.")
    @GetMapping("/members/check/detail")
    public ApiResponse<CustomBody<Void>> checkOnBoarding(
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        OnBoardingMemberQuery query = OnBoardingMemberQuery.of(memberId);
        boolean isOnBoarding = onBoardingMemberUsecase.checkOnBoarding(query);
        return ApiResponseGenerator.success(isOnBoarding, HttpStatus.OK);
    }
}
