package cn.murphy.springbootLearning;


import cn.murphy.springbootLearning.config.SpringUtils;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class App {

    public HttpMessageConverters faMessageConverters(){
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }

    /**注册 Spring Util
     * 这里为了和上一个冲突，所以方面名为：springUtil2
     * 实际中使用 springUtil
     */
    @Bean
    public static SpringUtils getSpringUtil(){return  new SpringUtils();}

    /**
     *  参数里 VM 参数设置为：
     * -javaagent:.\lib\springloaded-1.2.4.RELEASE.jar -noverify
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello bin");

        SpringApplication.run(App.class,args);


        SpringUtils springUtils = getSpringUtil();
        Hello hello = (Hello) SpringUtils.getBean("hello");
        System.out.println(hello.helloWorld());
    }




}
