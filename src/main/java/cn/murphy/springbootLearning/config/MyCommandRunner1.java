package cn.murphy.springbootLearning.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
@Order(value = 1) // 设置启动执行顺序
public class MyCommandRunner1 implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(MyCommandRunner1.class);


    @Override
    public void run(String... args) throws Exception {
        logger.info("执行启动任务1......");
        System.out.println("执行启动任务1......");
    }
}
