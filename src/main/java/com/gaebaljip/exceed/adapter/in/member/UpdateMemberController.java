package com.gaebaljip.exceed.adapter.in.member;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.gaebaljip.exceed.adapter.in.member.request.UpdateMemberRequest;
import com.gaebaljip.exceed.application.port.in.member.UpdateMemberCommand;
import com.gaebaljip.exceed.application.port.in.member.UpdateMemberUsecase;
import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.annotation.AuthenticationMemberId;
import com.gaebaljip.exceed.common.docs.SwaggerTag;
import com.gaebaljip.exceed.common.docs.member.UpdateMemberExceptionDocs;
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
@Tag(name = SwaggerTag.MEMBER_MANAGEMENT)
public class UpdateMemberController {
    private final UpdateMemberUsecase updateMemberUsecase;

    @Operation(summary = "회원 수정", description = "회원정보를 수정한다.")
    @PutMapping("/members")
    @ApiErrorExceptionsExample(UpdateMemberExceptionDocs.class)
    public ApiResponse<ApiResponse.CustomBody<Void>> updateMember(
            @RequestBody @Valid UpdateMemberRequest updateMemberRequest,
            @Parameter(hidden = true) @AuthenticationMemberId Long memberId) {
        UpdateMemberCommand command = UpdateMemberCommand.of(memberId, updateMemberRequest);
        updateMemberUsecase.execute(command);
        return ApiResponseGenerator.success(HttpStatus.OK);
    }
}
