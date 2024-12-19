package com.gaebaljip.exceed.common.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.gaebaljip.exceed.common.helper.SpringEnvironmentHelper;
import com.gaebaljip.exceed.common.security.domain.JwtManager;
import com.gaebaljip.exceed.common.security.domain.JwtResolver;
import com.gaebaljip.exceed.common.security.exception.JwtAccessDeniedHandler;
import com.gaebaljip.exceed.common.security.exception.JwtAuthenticationPoint;
import com.gaebaljip.exceed.common.security.filter.JwtAuthenticationFilter;
import com.gaebaljip.exceed.common.security.service.MemberDetailService;

import lombok.RequiredArgsConstructor;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtManager jwtManager;
    private final JwtResolver jwtResolver;
    private final MemberDetailService memberDetailService;
    private final JwtAuthenticationPoint jwtAuthenticationPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final SpringEnvironmentHelper springEnvironmentHelper;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // httpBasic, csrf, formLogin, rememberMe, logout, session disable
        http.httpBasic()
                .disable()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .rememberMe()
                .disable()
                .logout()
                .disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(jwtAuthenticationPoint)
                .and()
                .exceptionHandling()
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                .headers()
                .frameOptions()
                .sameOrigin();

        // 요청에 대한 권한 설정
        http.authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest)
                .permitAll()
                .antMatchers(
                        HttpMethod.GET,
                        "/v1/members/email/checked",
                        "/actuator/**",
                        "/v1/health",
                        "/v1//findPassword-redirect",
                        "/v1/signUp-redirect",
                        "/v1")
                .permitAll()
                .antMatchers(HttpMethod.PUT, "/v1/members/email/confirmed")
                .permitAll()
                .antMatchers(HttpMethod.PATCH, "/v1/members/checked", "/v1/members/find-password")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/v1/members", "/v1/email")
                .permitAll()
                .antMatchers(HttpMethod.POST, "/v1/auth/login", "/v1/auth/refresh")
                .permitAll()
                .antMatchers(
                        "/swagger-resources/**",
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/v3/api-docs",
                        "/api-docs/**",
                        "/api-docs")
                .permitAll()
                .anyRequest()
                .authenticated();

        // jwt filter 설정
        http.addFilterBefore(
                new JwtAuthenticationFilter(
                        jwtManager, jwtResolver, memberDetailService, springEnvironmentHelper),
                UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) ->
                web.ignoring()
                        .antMatchers("/favicon.*", "/*/icon-*")
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
