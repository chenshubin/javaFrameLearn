package cn.murphy.springbootLearning.controller;

import cn.murphy.springbootLearning.config.SqlConfig;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")

public class SystemEnvironmentController implements EnvironmentAware {

    private static Environment environment;

    @Autowired
    private SqlConfig sqlConfig;

    private Logger logger = LoggerFactory.getLogger(SystemEnvironmentController.class);


    @Override
    public void setEnvironment(Environment environment) {
        if(null == this.environment){
            this.environment = environment;
        }
    }

    @RequestMapping("/getJavaHome")
    public String getJavaHome(){
        String java_home = environment.getProperty("JAVA_HOME");
        logger.info("控制器中获取的系统环境变量：" + java_home);
        return java_home;
    }

    @RequestMapping("/getSqlConfig")
    public String getSqlConfig(){

        logger.info(JSONObject.toJSONString(sqlConfig));
        return JSONObject.toJSONString(sqlConfig);
    }



}
