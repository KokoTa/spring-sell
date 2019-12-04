package com.example.demo.handler;

import com.example.demo.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author KokoTa
 * @create 2019/12/3
 */
@ControllerAdvice
public class CustomException {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e) {
        System.out.println(123);

        ResultVo result = new ResultVo();
        result.setCode(500);
        result.setMsg(e.getMessage());

        return result;
    }

}
