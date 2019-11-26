package com.example.demo.exception;

import lombok.Getter;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@Getter
public class SellException extends RuntimeException {

    private Integer code;

    private String msg;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public SellException(Integer code, String defaultMessage) {
        super(defaultMessage);

        this.code = code;
        this.msg = defaultMessage;
    }
}
