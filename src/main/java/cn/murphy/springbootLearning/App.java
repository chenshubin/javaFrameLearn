package cn.murphy.springbootLearning;


import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class App {

    public HttpMessageConverters faMessageConverters(){
        return new HttpMessageConverters(new FastJsonHttpMessageConverter());
    }



    public static void main(String[] args) {
        System.out.println("Hello bin");

        SpringApplication.run(App.class,args);
    }




}
