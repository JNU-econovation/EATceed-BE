package com.gaebaljip.exceed.common.exception;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EatCeedAsyncUncaughtExceptionHandler implements AsyncUncaughtExceptionHandler {
    @Override
    public void handleUncaughtException(Throwable ex, Method method, Object... params) {
        log.error(
                "Exception in async method: {}, Params: {}, Message : {}",
                method.getName(),
                Arrays.toString(params),
                ex.getMessage());
    }
}
