package com.example.demo.exception;

import lombok.Getter;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10, "商品不存在"), PRODUCT_STOCK_ERROR(11, "库存不正确"), ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单明细不存在"), ORDER_STATUS_ERROR(14, "取消订单状态错误"), ORDER_UPDATE_FAIL(15, "订单更新失败");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
