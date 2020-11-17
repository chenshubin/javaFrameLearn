package cn.murphy.springbootLearning.controller;

import cn.murphy.springbootLearning.pojo.Demo;
import cn.murphy.springbootLearning.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class DemoJpaController {

    private Logger logger = LoggerFactory.getLogger(DemoJpaController.class);

    @Autowired
    private DemoService demoService ;

    @RequestMapping("/getDemo")
    public Demo getDemo(@RequestParam Long id){
        return demoService.findById(id);

    }


    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }

    @RequestMapping("/save")
    public Demo save(@RequestParam String name, @RequestParam Integer age){
        Demo demo = new Demo();
        demo.setName(name);
        demo.setAge(age);
        return demoService.save(demo);

    }




}
