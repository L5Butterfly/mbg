package com.oxygen.mbgtools.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 线程池的配置
 * @author oxygen
 * @date 2020/7/8
 **/
//@Configuration
//@EnableAsync
@Slf4j
public class ThreadPoolConfig {


    /**
     * 1. 当一个任务被提交到线程池时，首先查看线程池的核心线程是否都在执行任务，否就选择一条线程执行任务，是就执行第二步。
     * 2. 查看核心线程池是否已满，不满就创建一条线程执行任务，否则执行第三步。
     * 3. 查看任务队列是否已满，不满就将任务存储在任务队列中(SynchronousQueue同步队直接执行第四步)，否则执行第四步。
     * 4. 查看线程池是否已满，不满就创建一条线程执行任务，否则就按照策略处理无法执行的任务。
     *
     * 参数配置：
     * 1.SpringBoot配置ThreadPoolTaskExecutor：https://blog.csdn.net/weixin_43142697/article/details/83788228
     * 2.浅谈ThreadPoolExecute(JDK8)：https://blog.csdn.net/weixin_43142697/article/details/82875437
     * 3.Springboot学习笔记（一）-线程池的简化及使用：https://www.cnblogs.com/yw0219/p/8810956.html
     * 4. Springboot 线程池 ThreadPoolTaskExecutor 的一种容灾思路
     * https://blog.csdn.net/ameng734086045/article/details/87977246
     *
     *如上述代码已经配置好ThreadPoolTaskExecutor，在spring容器启动的时候会被初始化成bean存放在上下文中。
     * 需要使用的话只需要@autowired注入即可。
     * ThreadPoolTaskExecutor底层调用的就是ThreadPoolExecuter,关于Lee老爷子的线程池原理可以参考之前的一篇博文
     * https://blog.csdn.net/weixin_43142697/article/details/82875437
     *
     */


    /** corePoolSize 线程池维护线程的最少数量 */
    private final static int corePoolSize=16;

    /** maxPoolSize 线程池维护线程的最大数量 */
    private final static int maxPoolSize = 64;

    /** queueCapacity 缓存队列3000 */
    private final static int queueCapacity = 40;

    /** threadNamePrefix 执行线程前缀 */
    private final static String threadNamePrefix = "AsyncExecutorThread-";

    /** 线程池维护线程所允许的空闲时间 */
    private final static int keepAliveSeconds = 300;


    /**
     * poolTaskExecutor 执行器配置
     * @return
     */
    @Bean
    public Executor executor(){
        log.info("executor init start");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //此方法返回可用处理器的虚拟机的最大数量; 不小于1
        int core = Runtime.getRuntime().availableProcessors();
        log.info(String.format("1.可用处理器的虚拟机的最大数量:%d",core));
        //设置核心线程数
        /**executor.setCorePoolSize(core);**/
        executor.setCorePoolSize(corePoolSize);
        //设置最大线程数
        /**executor.setMaxPoolSize(core*2 + 1);**/
        executor.setMaxPoolSize(maxPoolSize);
        log.info(String.format("2.设置最大线程数:%d",core*2 + 1));
        //除核心线程外的线程存活时间（秒）
        executor.setKeepAliveSeconds(keepAliveSeconds);
        //如果传入值大于0，底层队列使用的是LinkedBlockingQueue,否则默认使用SynchronousQueue
        executor.setQueueCapacity(queueCapacity);
        //线程名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);
        //设置拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        log.info("executor init success");
        return executor;
    }

}
