package com.example.demo.exception;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
public class AspectException extends RuntimeException {
    private Integer code;

    private String msg;

    public AspectException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());

        this.code = resultEnum.getCode();
        this.msg = resultEnum.getMsg();
    }

    public AspectException(Integer code, String defaultMessage) {
        super(defaultMessage);

        this.code = code;
        this.msg = defaultMessage;
    }
}
