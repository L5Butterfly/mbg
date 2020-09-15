package com.oxygen.mbgtools.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Spring线程池配置
 * @author oxygen
 * @date 2020/7/8
 **/
@ConfigurationProperties(prefix="thread")
@PropertySource({"classpath:config/threadpool.properties"})
@Configuration
@Slf4j
public class ExecutorPoolConfig {

    @Value("${thread.core.pool.size}")
    private int corePoolSize;

    @Value("${thread.max.pool.size}")
    private int maxPoolSize;

    @Value("${thread.min.pool.size}")
    private int minPoolSize;

    @Value("${thread.keepAliveSeconds}")
    private int keepAliveSeconds;

    @Value("${thread.queue.capacity}")
    private int queueCapacity;

    @Value("${thread.name.prefix}")
    private String threadNamePrefix;


    /**
     * Executor 执行器
     *
     * @return
     */
    @Bean
    public Executor lifePoolInit(){
        ThreadPoolTaskExecutor executor=new ThreadPoolTaskExecutor();

        log.info("thread pool task init：start");
        log.info("corePoolSize：{}",corePoolSize);
        log.info("maxPoolSize：{}",maxPoolSize);
        log.info("keepAliveSeconds：{}",keepAliveSeconds);
        log.info("queueCapacity：{}",queueCapacity);
        log.info("threadNamePrefix：{}",threadNamePrefix);

        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepAliveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(threadNamePrefix);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        log.info("thread pool task init：end");
        return executor;
    }
}
