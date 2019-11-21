package com.example.demo.vo;

import lombok.Data;

/**
 * Http 请求返回的最外层对象 ResultVo
 */
@Data
public class ResultVo<T> {

  // 错误码
  private Integer code;

  // 提示信息
  private String msg;

  // 具体内容
  private T data;
}