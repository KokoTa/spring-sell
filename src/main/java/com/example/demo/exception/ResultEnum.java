package com.example.demo.exception;

import lombok.Getter;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1, "参数错误"),
    PRODUCT_NOT_EXIST(10, "商品不存在"),
    PRODUCT_STOCK_ERROR(11, "库存不正确"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单明细不存在"),
    ORDER_STATUS_ERROR(14, "订单状态错误"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单状态错误"),
    CART_EMPTY(18, "购物车不能为空"),
    ORDER_OWNER_ERROR(19, "该订单不属于当前用户"),
    WX_MP_ERROR(20, "微信公众账号方面错误"),
    ORDER_PAY_AMOUNT_ERROR(21, "支付后的订单金额不一致");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
