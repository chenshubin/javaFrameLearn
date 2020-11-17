package cn.murphy.springbootLearning.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Order(value = 2) // 设置启动执行顺序
public class MyCommandRunner2 implements CommandLineRunner {

    private Logger logger = Logger.getLogger("MyCommandRunner2");


    @Override
    public void run(String... args) throws Exception {
        logger.info("执行启动任务2......");
        System.out.println("执行启动任务2......");
    }
}
