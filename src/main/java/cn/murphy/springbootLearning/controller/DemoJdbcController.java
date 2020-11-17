package cn.murphy.springbootLearning.controller;

import cn.murphy.springbootLearning.pojo.Demo;
import cn.murphy.springbootLearning.service.DemoJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class DemoJdbcController {

    @Autowired
    private DemoJdbcService demoJdbcService;

    @ResponseBody
    @RequestMapping("/show")
    public Demo showDemo(@RequestParam(name = "no", defaultValue = "1", required = true) Long id) {

        return demoJdbcService.getById(id);
    }



}
