package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ProductInfoRepository;
import com.example.demo.entity.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductInfoRepository repository;

  @Override
  public ProductInfo findOne(String productId) {
    Optional<ProductInfo> p = repository.findById(productId);

    if (p.isPresent()) {
      return p.get();
    }

    return null;
  }

  @Override
  public List<ProductInfo> findUpAll() {
    return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
  }

  @Override
  public Page<ProductInfo> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public ProductInfo save(ProductInfo productInfo) {
    return repository.save(productInfo);
  }

}