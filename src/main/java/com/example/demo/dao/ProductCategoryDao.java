package com.example.demo.dao;

import com.example.demo.entity.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * 这个 Dao 可有可不有
 * @author KokoTa
 * @create 2019/11/27
 */
public class ProductCategoryDao {

    @Autowired
    ProductCategoryMapper mapper;

    public int insertByMap(Map<String, Object> map) {
        return mapper.insertByMap(map);
    }

}
