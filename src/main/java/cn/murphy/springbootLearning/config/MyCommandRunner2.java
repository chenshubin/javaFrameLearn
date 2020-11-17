package cn.murphy.springbootLearning.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(value = 2) // 设置启动执行顺序
public class MyCommandRunner2 implements CommandLineRunner {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(MyCommandRunner2.class);


    @Override
    public void run(String... args) throws Exception {
        logger.info("执行启动任务2......");
        System.out.println("执行启动任务2......");
    }
}
