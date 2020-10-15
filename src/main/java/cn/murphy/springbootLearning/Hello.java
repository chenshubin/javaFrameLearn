package cn.murphy.springbootLearning;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Hello {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "Hello bin1";
    }

    @RequestMapping("/helloWorld")
    public String helloWorld(){return "Hello world";}



}
