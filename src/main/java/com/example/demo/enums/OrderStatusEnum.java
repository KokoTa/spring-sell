package com.example.demo.enums;

import lombok.Getter;

/**
 * OrderStatusEnum
 */
@Getter
public enum OrderStatusEnum {
  NEW(0, "新订单"), FINISH(1, "完结"), CANCEL(2, "已取消");

  private Integer code;

  private String msg;

  OrderStatusEnum(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}