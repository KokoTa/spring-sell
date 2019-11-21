package com.example.demo.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品类目对象 ProductVo
 */
@Data
public class ProductVo {

  // 这里返回给前端的是 name
  @JsonProperty("name")
  private String categoryName;

  @JsonProperty("type")
  private Integer categoryType;

  @JsonProperty("foods")
  private List<ProductInfoVo> productInfoVosList;
}