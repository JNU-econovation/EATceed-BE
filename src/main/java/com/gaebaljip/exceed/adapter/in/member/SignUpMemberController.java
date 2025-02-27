package com.gaebaljip.exceed.adapter.in.member;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.gaebaljip.exceed.adapter.in.member.request.SignUpMemberRequest;
import com.gaebaljip.exceed.application.port.in.member.*;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.docs.member.SignUpMemberExceptionDocs;
import com.gaebaljip.exceed.common.swagger.ApiErrorExceptionsExample;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@SecurityRequirement(name = "access-token")
@Tag(name = SwaggerTag.SIGN_UP)
public class SignUpMemberController {

    private final ValidateSignUpUsecase validateSignUpUsecase;
    private final CreateMemberUsecase createMemberUsecase;

    @Operation(summary = "회원 가입", description = "회원 가입한다.")
    @PostMapping("/members")
    @ApiErrorExceptionsExample(SignUpMemberExceptionDocs.class)
    public ApiResponse<CustomBody<Void>> signUpMember(
            @RequestBody @Valid SignUpMemberRequest signUpMemberRequest) {
        validateSignUpUsecase.execute(
                new ValidateSignUpCommand(
                        signUpMemberRequest.email(), signUpMemberRequest.password()));
        createMemberUsecase.execute(signUpMemberRequest);
        return ApiResponseGenerator.success(HttpStatus.CREATED);
    }
}
