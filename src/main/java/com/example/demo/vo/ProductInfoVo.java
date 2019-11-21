package com.example.demo.vo;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品详情对象 ProductVo
 */
@Data
public class ProductInfoVo {

  @JsonProperty("id")
  private String productId;

  @JsonProperty("name")
  private String productName;

  @JsonProperty("price")
  private BigDecimal productPrice;

  @JsonProperty("description")
  private String productDescription;

  @JsonProperty("icon")
  private String productIcon;
}