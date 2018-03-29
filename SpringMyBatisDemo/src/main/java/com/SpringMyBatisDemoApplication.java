package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.*.dao")
@ServletComponentScan
@EnableScheduling // 启用定时器
@EnableSwagger2 // API文档
public class SpringMyBatisDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMyBatisDemoApplication.class, args);
    }

    /**
     * 配置定时任务线程池
     */
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler task = new ThreadPoolTaskScheduler();
        task.setPoolSize(10);// 线程池默认大小
        task.setThreadNamePrefix("SchedulerPool-");
        return task;

    }
}
