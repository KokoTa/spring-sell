package com.example.demo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * OrderMaster
 */
@Entity
@Data
@DynamicUpdate
@DynamicInsert
public class OrderMaster {

  @Id
  private String orderId;

  private String buyerName;

  private String buyerPhone;

  private String buyerAddress;

  private String buyerOpenid;

  private BigDecimal orderAmount;

  // 默认 0 新下单
  private Integer orderStatus = OrderStatusEnum.NEW.getCode();

  // 默认 0 未支付
  private Integer payStatus = PayStatusEnum.WAIT.getCode();

  private Date createTime;

  private Date updateTime;

}