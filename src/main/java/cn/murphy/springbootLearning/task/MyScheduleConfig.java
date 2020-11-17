package cn.murphy.springbootLearning.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.logging.Logger;


@Configuration // 声明类为系统配置类
@EnableScheduling  // 开启调度任务
public class MyScheduleConfig {
    private Logger logger = Logger.getLogger("MyScheduleConfig.class");

    @Scheduled(cron = "0 0/10 * * * ?") // 定义调度器
    public void job1() {
        logger.info("this is my first job execute");
        System.out.println("this is my first job execute");
    }



}
