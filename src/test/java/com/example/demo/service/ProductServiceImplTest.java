package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.entity.ProductInfo;
import com.example.demo.service.impl.ProductServiceImpl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductServiceImplTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

  @Autowired
  private ProductServiceImpl service;

  @Test
  public void findOne() {
    ProductInfo p = service.findOne("1111");
    Assert.assertEquals("1111", p.getProductId());
  }

  @Test
  public void findUpAll() {
    List<ProductInfo> list = service.findUpAll();
    Assert.assertNotEquals(0, list.size());
  }

  @Test
  public void findAll() {
    PageRequest request = PageRequest.of(0, 2);
    Page<ProductInfo> page = service.findAll(request);
    Assert.assertNotEquals(0, page.getTotalElements());
  }

  @Test
  public void save() {
    ProductInfo p = new ProductInfo();
    p.setProductId("1234");
    p.setProductName("雪碧");
    p.setProductPrice(new BigDecimal(2.5));
    p.setProductStock(200);
    p.setProductDescription("肥宅快乐水");
    p.setProductIcon("http://xxx.com");
    p.setProductStatus(1);
    p.setCategoryType(4);
    p = service.save(p);
    Assert.assertNotNull(p);
  }

}