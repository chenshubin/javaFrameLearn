package cn.murphy.springbootLearning.controller;

import cn.murphy.springbootLearning.config.WebAppConfig;
import cn.murphy.springbootLearning.pojo.Demo;
import cn.murphy.springbootLearning.service.DemoJdbcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jdbc")
public class DemoJdbcController {

    private Logger logger = LoggerFactory.getLogger(DemoJdbcController.class);

    @Autowired
    private DemoJdbcService demoJdbcService;

    @ResponseBody
    @RequestMapping("/show")
    public Demo showDemo(@RequestParam(name = "no", defaultValue = "1", required = true) Long id) {

        return demoJdbcService.getById(id);
    }



}
