package com.example.demo.handler;

import com.example.demo.exception.AspectException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@ControllerAdvice
public class AspectExceptionHandler {

    @ExceptionHandler(value = AspectException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void handleAspectException() {
        System.out.println("我拦截了 AspectException 错误");
    }
}
