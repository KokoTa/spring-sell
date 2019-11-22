package com.example.demo.dto;

import com.example.demo.entity.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * date transform object
 * 数据传输对象，即请求传入以及在各层传输的对象
 * @author KokoTa
 * @create 2019/11/22
 */
@Data
public class OrderDTO {

  private String orderId;

  private String buyerName;

  private String buyerPhone;

  private String buyerAddress;

  private String buyerOpenid;

  private BigDecimal orderAmount;

  // 默认 0 新下单
  private Integer orderStatus;

  // 默认 0 未支付
  private Integer payStatus;

  private Date createTime;

  private Date updateTime;

  private List<OrderDetail> orderDetailList;
}
