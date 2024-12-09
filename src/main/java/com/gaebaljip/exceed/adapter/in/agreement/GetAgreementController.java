package com.gaebaljip.exceed.adapter.in.agreement;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.adapter.in.agreement.response.GetPrivacyPolicyResponse;
import com.gaebaljip.exceed.adapter.in.agreement.response.GetTermsServiceAgreeResponse;
import com.gaebaljip.exceed.adapter.in.announce.response.GetAnnounceResponse;
import com.gaebaljip.exceed.application.port.in.agreement.GetAgreementQuery;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.annotation.AuthenticationMemberId;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.dto.GetAgreementDTO;

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
public class GetAgreementController {

    private final GetAgreementQuery getAgreementQuery;

    @Operation(summary = "개인 정보 처리방침 동의 여부 조회", description = "개인 정보 처리방침 여부를 조회한다.")
    @GetMapping("/agreement/privacyPolicy")
    public ApiResponse<CustomBody<GetAnnounceResponse>> getPrivacyPolicyStatus(
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        GetAgreementDTO getAgreementDTO = getAgreementQuery.execute(memberId);
        return ApiResponseGenerator.success(
                GetPrivacyPolicyResponse.from(getAgreementDTO.isPrivacyPolicyAgree()),
                HttpStatus.OK);
    }

    @Operation(summary = "약관 동의 여부 조회", description = "약관 동의 여부를 조회한다.")
    @GetMapping("/agreement/termService")
    public ApiResponse<CustomBody<GetAnnounceResponse>> getTermOfServiceStatus(
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        GetAgreementDTO getAgreementDTO = getAgreementQuery.execute(memberId);
        return ApiResponseGenerator.success(
                GetTermsServiceAgreeResponse.from(getAgreementDTO.isTermsServiceAgree()),
                HttpStatus.OK);
    }
}
