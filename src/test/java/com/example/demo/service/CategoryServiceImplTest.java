package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.example.demo.entity.ProductCategory;
import com.example.demo.service.impl.CategoryServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CategoryServiceImplTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

  @Autowired
  private CategoryServiceImpl service;

  @Test
  public void findOne() {
    ProductCategory productCategory = service.findOne(1);
    Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
  }

  @Test
  public void findAll() {
    List<ProductCategory> list = service.findAll();
    Assert.assertNotEquals(0, list.size());
  }

  @Test
  public void findByCategoryTypeIn() {
    List<ProductCategory> list = service.findByCategoryTypeIn(Arrays.asList(1, 2, 3, 4));
    Assert.assertNotEquals(0, list.size());
  }

  @Test
  @Transactional
  public void save() {
    ProductCategory c = new ProductCategory();
    c.setCategoryName("测试");
    c.setCategoryType(999);
    c = service.save(c);
    Assert.assertEquals("测试", c.getCategoryName());
  }
}