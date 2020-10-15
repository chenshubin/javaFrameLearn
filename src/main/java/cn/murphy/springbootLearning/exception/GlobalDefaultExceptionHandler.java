package cn.murphy.springbootLearning.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public void defaulrErrorHandler(HttpServletRequest req, Exception e){
        e.printStackTrace();
        System.out.println("GlobalDefaultExceptionHandler.defaulrErrorHandler");
    }


}
