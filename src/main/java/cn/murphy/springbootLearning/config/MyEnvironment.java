package cn.murphy.springbootLearning.config;

import cn.murphy.springbootLearning.test.AliOssDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class MyEnvironment implements EnvironmentAware {

    private Logger logger = LoggerFactory.getLogger(MyEnvironment.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;


    @Override
    public void setEnvironment(Environment environment) {
        logger.info(dbUrl);

        logger.info("JAVA_HOME" + environment.getProperty("JAVA_HOME"));
        // 获取spring主配置文件中的属性
        logger.info("spring.datasource.url:" + environment.getProperty("spring.datasource.url"));


    }
}
