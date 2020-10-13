package cn.murphy.springbootLearning;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("Hello bin");

        SpringApplication.run(App.class,args);
    }

    @RequestMapping("/")
    public String sayHello(){
        return "Hello bin1";
    }


}
