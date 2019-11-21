package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ProductInfo;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductInfoRepository
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

  List<ProductInfo> findByProductStatus(Integer productStatus);
}