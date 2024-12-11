package com.gaebaljip.exceed.common.version;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaebaljip.exceed.common.ApiResponse;
import com.gaebaljip.exceed.common.ApiResponse.CustomBody;
import com.gaebaljip.exceed.common.ApiResponseGenerator;
import com.gaebaljip.exceed.common.docs.SwaggerTag;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/v1")
@Tag(name = SwaggerTag.VERSION)
public class GetVersionController {

    @Value("${app.version}")
    private String version;

    @Operation(summary = "앱 버전 조회", description = "앱 버전 조회")
    @GetMapping("")
    public ApiResponse<CustomBody<String>> getVersion() {
        return ApiResponseGenerator.success(new GetVersionResponse(version), HttpStatus.OK);
    }
}
