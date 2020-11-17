package cn.murphy.springbootLearning;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    private Logger logger = LoggerFactory.getLogger(Hello.class);

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello bin1";
    }

    @RequestMapping("/helloWorld")
    public String helloWorld(){return "Hello world";}



}
