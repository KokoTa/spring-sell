package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 * ProductCategory
 */
@Entity
@DynamicUpdate // 动态更新，传入什么值就更新什么值
@Data // 可以省去写 getter/setter/toString...
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer categoryId;

  private String categoryName;

  private Integer categoryType;

}