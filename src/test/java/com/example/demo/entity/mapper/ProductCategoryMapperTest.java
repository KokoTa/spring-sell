package com.example.demo.entity.mapper;

import com.example.demo.entity.ProductCategory;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KokoTa
 * @create 2019/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper mapper;

    @Test
    void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "哈哈哈");
        map.put("category_type", 5);

        int result = mapper.insertByMap(map);
        Assert.assertEquals(1, result);
    }

    @Test
    void insertByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("嘿嘿嘿");
        productCategory.setCategoryType(6);

        int result = mapper.insertByObject(productCategory);
        Assert.assertEquals(1, result);
    }

    @Test
    void findByCategoryType() {
        List<ProductCategory> result = mapper.findByCategoryType(5);
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    void updateByCategoryType() {
        int result = mapper.updateByCategoryType("呱呱", 5);
        Assert.assertNotEquals(0, result);
    }

    @Test
    void deleteByCategoryType() {
        int result = mapper.deleteByCategoryType(5);
        Assert.assertNotEquals(0, result);
    }
}