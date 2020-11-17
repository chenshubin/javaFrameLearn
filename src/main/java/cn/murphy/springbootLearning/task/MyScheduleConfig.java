package cn.murphy.springbootLearning.task;

import cn.murphy.springbootLearning.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;



@Configuration // 声明类为系统配置类
@EnableScheduling  // 开启调度任务
public class MyScheduleConfig {

    private Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Scheduled(cron = "0 0/10 * * * ?") // 定义调度器
    public void job1() {
        logger.info("this is my first job execute");
        System.out.println("this is my first job execute");
    }



}
