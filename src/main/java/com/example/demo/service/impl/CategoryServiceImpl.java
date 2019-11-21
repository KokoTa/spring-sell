package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ProductCategoryRepository;
import com.example.demo.entity.ProductCategory;
import com.example.demo.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * CategoryServiceImpl
 */
@Service
public class CategoryServiceImpl implements CategoryService {

  @Autowired
  private ProductCategoryRepository repository;

  @Override
  public ProductCategory findOne(Integer categoryId) {
    Optional<ProductCategory> opt = repository.findById(categoryId);

    if (opt.isPresent()) {
      return opt.get();
    }

    return null;
  }

  @Override
  public List<ProductCategory> findAll() {
    return repository.findAll();
  }

  @Override
  public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
    return repository.findByCategoryTypeIn(categoryTypeList);
  }

  @Override
  public ProductCategory save(ProductCategory productCategory) {
    return repository.save(productCategory);
  }

}