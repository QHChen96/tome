package com.khetao.tome.web.config;

import com.khetao.tome.web.task.ContextCopyingDecorator;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.Executor;

/**
 * @author chenqinhao 2022/7/3
 * @email qhchen96@gmail.com
 */
@Configurable
public class WebConfig {

    public static final String ASYNC_EXECUTOR_NAME = "asyncExecutor";


    @Bean(name = ASYNC_EXECUTOR_NAME)
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setTaskDecorator(new ContextCopyingDecorator());
        executor.setCorePoolSize(3);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(100);
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.setThreadNamePrefix("AsyncThread-");
        executor.initialize();
        return executor;
    }

}
