package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.ProductCategory;

/**
 * CategoryService
 */
public interface CategoryService {

  ProductCategory findOne(Integer categoryId);

  List<ProductCategory> findAll();

  List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

  ProductCategory save(ProductCategory productCategory);
}