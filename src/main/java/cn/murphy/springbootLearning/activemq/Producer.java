package cn.murphy.springbootLearning.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
@EnableScheduling
public class Producer {

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    @Async
    public void send(){
        template.convertAndSend(queue,"测试消息队列"+System.currentTimeMillis());
    }



}
