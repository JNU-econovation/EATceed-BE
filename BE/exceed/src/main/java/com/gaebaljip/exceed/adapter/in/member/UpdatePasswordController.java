package com.gaebaljip.exceed.adapter.in.member;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.adapter.in.member.request.UpdatePasswordRequest;
import com.gaebaljip.exceed.application.port.in.member.UpdatePasswordUsecase;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.annotation.AuthenticationMemberId;
import com.gaebaljip.exceed.common.docs.SwaggerTag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
@Tag(name = SwaggerTag.ACCOUNT_MANAGEMENT)
public class UpdatePasswordController {

    private final UpdatePasswordUsecase updatePasswordUsecase;

    @Operation(summary = "비밀번호 변경", description = "비밀번호를 변경할 때 사용한다. 해당 API는 로그인 후에 사용하는 API이다.")
    @PatchMapping("/members/password")
    public ApiResponse<CustomBody<Void>> updatePassword(
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId,
            @RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordUsecase.execute(memberId, request.oldPassword(), request.newPassword());
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
