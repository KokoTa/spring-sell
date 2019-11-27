package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * value object
 * 返回值对象，Http 请求返回的最外层对象
 *
 * 继承 serializable 以支持 Cache 时的序列化操作
 */
@Data
public class ResultVo<T> implements Serializable {

  private static final long serialVersionUID = -6817438114767794933L;

  // 错误码
  private Integer code;

  // 提示信息
  private String msg;

  // 具体内容
  private T data;
}