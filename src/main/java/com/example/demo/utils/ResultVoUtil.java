package com.example.demo.utils;

import com.example.demo.vo.ResultVo;

/**
 * ResultVoUtil
 */
public class ResultVoUtil {

  public static ResultVo<Object> success(Object obj) {
    ResultVo<Object> rvo = new ResultVo<>();
    rvo.setData(obj);
    rvo.setCode(0);
    rvo.setMsg("成功");
    return rvo;
  }

  public static ResultVo<Object> success() {
    return success(null);
  }

  public static ResultVo<Object> error(Integer code, String msg) {
    ResultVo<Object> rvo = new ResultVo<>();
    rvo.setCode(code);
    rvo.setMsg(msg);
    return rvo;
  }
}