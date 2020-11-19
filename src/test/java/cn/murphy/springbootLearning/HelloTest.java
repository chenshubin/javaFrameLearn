package cn.murphy.springbootLearning;

import cn.murphy.springbootLearning.controller.Hello;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = { App.class })
@SpringBootTest
public class HelloTest extends TestCase {

    // 自动装配业务逻辑层
    @Autowired
    private Hello hello;



    @Test
    public void sayHello() {
        System.out.println(hello.sayHello());
    }

    @Test
    public void helloWorld() {
        System.out.println(hello.helloWorld());
    }
}