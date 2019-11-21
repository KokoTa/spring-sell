package com.example.demo.dao;

import java.math.BigDecimal;
import java.util.List;
import com.example.demo.entity.ProductInfo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductInfoRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

  @Autowired
  private ProductInfoRepository repository;

  @Test
  public void save() {
    ProductInfo p = new ProductInfo();
    p.setProductId("1111");
    p.setProductName("可乐");
    p.setProductPrice(new BigDecimal(3.2));
    p.setProductStock(100);
    p.setProductDescription("肥宅快乐水");
    p.setProductIcon("http://xxx.com");
    p.setProductStatus(0);
    p.setCategoryType(4);
    p = repository.save(p);
    Assert.assertNotNull(p);
  }

  @Test
  public void findByProductStatus() {
    List<ProductInfo> list = repository.findByProductStatus(0);
    Assert.assertNotEquals(0, list.size());
  }

}