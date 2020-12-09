package edu.nf.ch21.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author 洒度
 * @date 2020/12/9
 */
@Configuration
@ComponentScan(basePackages = "edu.nf.ch21")
//启用定时任务注解处理器
@EnableScheduling
/**
 * 可以通过实现SchedulingConfigurer接口来配饰线程池
 */
public class AppConfig implements SchedulingConfigurer {

    /**
     * 装配一个定时任务线程池
     * @returnhg
     */
    @Bean(destroyMethod = "shutdown")
    public ThreadPoolTaskScheduler taskScheduler(){
        ThreadPoolTaskScheduler poolTaskScheduler=new ThreadPoolTaskScheduler();
        //设置线程池大小
        poolTaskScheduler.setPoolSize(5);
        //设置线程名称的前缀
        poolTaskScheduler.setThreadNamePrefix("任务线程-");
        return poolTaskScheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //注册定时任务线程池
        scheduledTaskRegistrar.setScheduler(taskScheduler());
    }
}
