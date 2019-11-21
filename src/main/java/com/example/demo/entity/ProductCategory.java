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
@DynamicUpdate
@Data // 可以省去写 getter/setter/toString...
public class ProductCategory {

  @Id
  @GeneratedValue
  private Integer categoryId;

  private String categoryName;

  private Integer categoryType;

}