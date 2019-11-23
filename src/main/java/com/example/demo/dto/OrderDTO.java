package com.example.demo.dto;

import com.example.demo.entity.OrderDetail;
import com.example.demo.utils.Date2LongSerializer;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * date transform object
 * 数据传输对象，即请求传入以及在各层传输的对象
 * @author KokoTa
 * @create 2019/11/22
 */
@Data
// @JsonInclude(JsonInclude.Include.NON_NULL) // 加了注解后，为 Null 的属性不会显示，但一个一个加很麻烦，可以去配置文件全局配置
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

  @JsonSerialize(using = Date2LongSerializer.class)
  private Date createTime;

  @JsonSerialize(using = Date2LongSerializer.class)
  private Date updateTime;

  // 订单详情列表
  private List<OrderDetail> orderDetailList;
}
