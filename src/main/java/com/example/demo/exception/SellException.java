package com.example.demo.exception;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
public class SellException extends RuntimeException {

    private Integer code;

    private String msg;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
    }
}
