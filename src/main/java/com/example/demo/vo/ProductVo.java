package com.example.demo.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * 商品类目对象 ProductVo
 */
@Data
public class ProductVo implements Serializable {

  private static final long serialVersionUID = -2341875812944849391L;

  // 这里返回给前端的是 name
  @JsonProperty("name")
  private String categoryName;

  @JsonProperty("type")
  private Integer categoryType;

  @JsonProperty("foods")
  private List<ProductInfoVo> productInfoVosList;
}