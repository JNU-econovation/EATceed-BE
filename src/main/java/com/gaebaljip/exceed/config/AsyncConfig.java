package com.gaebaljip.exceed.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.gaebaljip.exceed.common.exception.EatCeedAsyncUncaughtExceptionHandler;

@EnableAsync
@Configuration
@Profile("!test")
public class AsyncConfig implements AsyncConfigurer {
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(15);
        executor.setQueueCapacity(10);
        executor.setRejectedExecutionHandler(new AbortPolicy());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new EatCeedAsyncUncaughtExceptionHandler();
    }
}
