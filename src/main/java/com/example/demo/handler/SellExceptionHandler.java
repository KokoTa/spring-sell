package com.example.demo.handler;

import com.example.demo.exception.SellException;
import com.example.demo.utils.ResultVoUtil;
import com.example.demo.vo.ResultVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@ControllerAdvice
public class SellExceptionHandler {

    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResultVo handlerSellException(SellException e) {
        return ResultVoUtil.error(e.getCode(), e.getMsg());
    }
}
