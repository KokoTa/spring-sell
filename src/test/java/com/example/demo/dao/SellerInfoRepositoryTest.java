package com.example.demo.dao;

import com.example.demo.entity.SellerInfo;
import com.example.demo.utils.KeyUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository repository;

    @Test
    void save() {
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin");
        sellerInfo.setOpenid("abc");

        sellerInfo = repository.save(sellerInfo);
        Assert.assertNotNull(sellerInfo);
    }

    @Test
    void findByOpenid() {
        SellerInfo sellerInfo = repository.findByOpenid("abc");

        Assert.assertNotNull(sellerInfo);
    }
}