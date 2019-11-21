package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * ProductService
 */
public interface ProductService {

  ProductInfo findOne(String productId);

  List<ProductInfo> findUpAll();

  // 分页查询
  Page<ProductInfo> findAll(Pageable pageable);

  ProductInfo save(ProductInfo productInfo);

  // 加减库

  // 减库存

}