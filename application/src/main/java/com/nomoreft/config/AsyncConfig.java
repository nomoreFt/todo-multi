package com.nomoreft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class AsyncConfig {


    @Bean(name = "taskExecutor")
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);  // 50개 스레드를 사용하여 병렬 실행 강화
        executor.setMaxPoolSize(100);  // 최대 100개 스레드 동시 실행 가능
        executor.setQueueCapacity(200); // 큐 크기 증가 (기본 50)
        executor.setThreadNamePrefix("AsyncTask-");
        executor.setWaitForTasksToCompleteOnShutdown(true); // 종료 시 모든 작업 완료까지 대기
        executor.setAwaitTerminationSeconds(60);
        executor.initialize();
        return executor;
    }
}
