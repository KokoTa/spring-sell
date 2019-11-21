package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.ProductCategory;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductCategoryRepository
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
  // 方法命名要根据 JPA 规范，这里指代通过 categoryType 查询符合的对象，in 是 sql 中包含的意思
  List<ProductCategory> findByCategoryTypeIn(List<Integer> cIntegers);
}