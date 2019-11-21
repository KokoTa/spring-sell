package com.example.demo.dao;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.entity.ProductCategory;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductCategoryRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

  @Autowired
  private ProductCategoryRepository repository;

  @Test
  public void findOne() {
    Optional<ProductCategory> opt = repository.findById(1);
    Assert.assertNotNull(opt);
  }

  @Test
  public void saveOne() {
    ProductCategory productCategory = new ProductCategory();
    productCategory.setCategoryName("电器");
    productCategory.setCategoryType(3);
    ProductCategory result = repository.save(productCategory);
    Assert.assertEquals("电器", result.getCategoryName());
  }

  @Test
  @Transactional // Test 中的事务是直接回滚的，即不会影响到数据库
  public void updateOne() {
    Optional<ProductCategory> opt = repository.findById(2);
    if (opt.isPresent()) {
      // 为了实现时间的自动更新，需要在实体类中增加 @DynamicUpdate 注解
      ProductCategory productCategory = opt.get();
      productCategory.setCategoryType(10);
      ProductCategory result = repository.save(productCategory);
      Assert.assertEquals(new Integer(10), result.getCategoryType());
    }
  }

  @Test
  public void findByCategoryByIntList() {
    List<Integer> list = Arrays.asList(1, 2, 3, 4);
    List<ProductCategory> pList = repository.findByCategoryTypeIn(list);
    Assert.assertNotEquals(0, pList.size());
  }
}