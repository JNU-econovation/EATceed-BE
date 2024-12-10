package com.gaebaljip.exceed.adapter.in.agreement;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.adapter.in.agreement.request.AgreePrivacyPolicyRequest;
import com.gaebaljip.exceed.adapter.in.agreement.request.AgreeTermsServiceRequest;
import com.gaebaljip.exceed.application.port.in.agreement.AgreePrivacyPolicyUsecase;
import com.gaebaljip.exceed.application.port.in.agreement.AgreeTermsUsecase;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.annotation.AuthenticationMemberId;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.docs.agreement.AgreePrivacyPolicyDocs;
import com.gaebaljip.exceed.common.docs.agreement.AgreeTermsServiceDocs;
import com.gaebaljip.exceed.common.swagger.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@SecurityRequirement(name = "access-token")
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1")
@Tag(name = SwaggerTag.AGREEMENT)
public class UpdateAgreementController {

    private final AgreePrivacyPolicyUsecase agreePrivacyPolicyUsecase;
    private final AgreeTermsUsecase agreeTermsUsecase;

    @Operation(summary = "개인 정보 처리방침 동의", description = "개인 정보 처리방침을 동의한다.")
    @PatchMapping("/agreement/privacyPolicy")
    @ApiErrorExceptionsExample(AgreePrivacyPolicyDocs.class)
    public ApiResponse<CustomBody<Void>> agreePrivacyPolicy(
            @RequestBody @Valid AgreePrivacyPolicyRequest request,
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        agreePrivacyPolicyUsecase.execute(memberId, request.isPrivacyPolicyAgree());
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @Operation(summary = "약관 동의", description = "약관을 동의한다.")
    @PatchMapping("/agreement/termService")
    @ApiErrorExceptionsExample(AgreeTermsServiceDocs.class)
    public ApiResponse<CustomBody<Void>> agreeTermOfService(
            @RequestBody @Valid AgreeTermsServiceRequest request,
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        agreeTermsUsecase.execute(memberId, request.isTermsServiceAgree());
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
