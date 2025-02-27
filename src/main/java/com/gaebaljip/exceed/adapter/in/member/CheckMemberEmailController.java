package com.gaebaljip.exceed.adapter.in.member;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.gaebaljip.exceed.adapter.in.member.request.CheckMemberRequest;
import com.gaebaljip.exceed.application.port.in.member.CheckCodeUsecase;
import com.gaebaljip.exceed.application.port.in.member.UpdateCheckedUsecase;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.docs.member.CheckMemberEmailExceptionDocs;
import com.gaebaljip.exceed.common.swagger.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = SwaggerTag.SIGN_UP)
public class CheckMemberEmailController {

    private final CheckCodeUsecase checkCodeUsecase;
    private final UpdateCheckedUsecase updateCheckedUsecase;

    @Value("${exceed.deepLink.signUp}")
    private String deepLink;

    @Operation(summary = "이메일 코드 확인", description = "해당 이메일의 인증 코드인지 확인한다.(딥링크로 들어간 화면에서 사용)")
    @PatchMapping("/members/checked")
    @ApiErrorExceptionsExample(CheckMemberEmailExceptionDocs.class)
    public ApiResponse<ApiResponse.CustomBody<Void>> checkMemberEmail(
            @RequestBody @Valid CheckMemberRequest checkMemberRequest) {
        checkCodeUsecase.execute(checkMemberRequest.email(), checkMemberRequest.code());
        updateCheckedUsecase.execute(checkMemberRequest.email());
        return ApiResponseGenerator.success(HttpStatus.OK);
    }

    @Operation(summary = "링크 클릭시 리다이렉트", description = "AOS는 몰라도 되는 API")
    @GetMapping("/signUp-redirect")
    public void redirect(HttpServletResponse response) {
        response.setHeader("Location", deepLink);
        response.setStatus(302);
    }
}
