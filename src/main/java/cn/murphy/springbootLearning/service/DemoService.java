package cn.murphy.springbootLearning.service;

import cn.murphy.springbootLearning.pojo.Demo;
import cn.murphy.springbootLearning.repository.IDemoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DemoService {

    private Logger logger = LoggerFactory.getLogger(DemoService.class);

    @Autowired
    private IDemoRepository demoRepository;

    @Transactional
    public Demo save(Demo demo){

        return   demoRepository.save(demo);
    }


    public Demo findById(Long id){
       return demoRepository.findById(id).orElse(null);
    }


}
