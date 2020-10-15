package cn.murphy.springbootLearning;

import cn.murphy.springbootLearning.pojo.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setId(123456L);
        demo.setName("Bin1");
        return demo;
    }


    @RequestMapping("zeroException")
    public int zeroException(){
        return 100/0;
    }



}
