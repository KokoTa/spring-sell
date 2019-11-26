package com.example.demo.handler;

import com.example.demo.exception.AspectException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@ControllerAdvice
public class AspectExceptionHandler {

    @ExceptionHandler(value = AspectException.class)
    public String handleAspectException() {
        return "我不会返回正常消息，因为我被拦截啦！";
    }
}
