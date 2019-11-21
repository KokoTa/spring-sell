package com.example.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

/**
 * ProductInfo
 */
@Entity
@Data
public class ProductInfo {

  @Id
  private String productId;

  private String productName;

  private BigDecimal productPrice;

  private Integer productStock;

  private String productDescription;

  private String productIcon;

  // 0 正常 1 下架
  private Integer productStatus;

  private Integer categoryType;
}