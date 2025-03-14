package com.gaebaljip.exceed.common;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.services.ses.SesClient;

@Configuration
public class MockSesConfig {
    @Bean
    public SesClient sesClient() {
        return Mockito.mock(SesClient.class);
    }
}
