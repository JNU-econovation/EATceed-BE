package com.gaebaljip.exceed.common.security.filter;

import static com.gaebaljip.exceed.common.EatCeedStaticMessage.SwaggerPatterns;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gaebaljip.exceed.common.helper.SpringEnvironmentHelper;
import com.gaebaljip.exceed.common.security.domain.JwtManager;
import com.gaebaljip.exceed.common.security.domain.JwtResolver;
import com.gaebaljip.exceed.common.security.domain.MemberDetails;
import com.gaebaljip.exceed.common.security.service.MemberDetailService;
import com.gaebaljip.exceed.common.swagger.SwaggerCannotProdException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtManager jwtManager;
    private final JwtResolver jwtResolver;
    private final MemberDetailService memberDetailService;
    private final SpringEnvironmentHelper springEnvironmentHelper;
    private final List<String> excludeUrl = List.of("/actuator", "/v1/health");

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // prod 환경에서 swagger 요청을 차단
        if (Boolean.TRUE.equals(springEnvironmentHelper.isProdProfile())
                && isSwaggerRequest(request)) {
            request.setAttribute(
                    "swaggerCannotProdException", SwaggerCannotProdException.EXCEPTION);
            throw SwaggerCannotProdException.EXCEPTION;
        }

        final String bearerToken = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (bearerToken == null || !bearerToken.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String accessToken = jwtResolver.extractToken(bearerToken);
        try {
            if (jwtManager.validateAccessToken(accessToken, request)) {
                MemberDetails memberDetails =
                        (MemberDetails)
                                memberDetailService.loadUserByUsername(
                                        jwtResolver.getMemberIdFromToken(accessToken));
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(
                                memberDetails, null, memberDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authentication);
                log.info(
                        "user ={}, uri ={}, method = {}, time={}, message={}",
                        request.getRemoteUser(),
                        request.getRequestURL(),
                        request.getMethod(),
                        LocalDateTime.now(),
                        "인증 성공");
            }
        } catch (Exception e) {
            log.error(
                    "method ={}, URL = {}, time={}, errorMessage={}",
                    request.getMethod(),
                    request.getRequestURL(),
                    LocalDateTime.now(),
                    e.getMessage());
            request.setAttribute("exception", e);
        }
        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        boolean flag = false;
        for (String url : excludeUrl) {
            if (path.contains(url)) {
                flag = true;
            }
        }
        return flag;
    }

    private boolean isSwaggerRequest(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        return PatternMatchUtils.simpleMatch(SwaggerPatterns, servletPath);
    }
}
