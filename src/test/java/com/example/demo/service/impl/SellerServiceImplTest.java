package com.example.demo.service.impl;

import com.example.demo.entity.SellerInfo;
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
class SellerServiceImplTest {

    @Autowired
    private SellerServiceImpl service;

    private static final String OPENID = "abc";

    @Test
    void findSellerInfoByOpenid() {
        SellerInfo sellerInfo = service.findSellerInfoByOpenid(OPENID);
        Assert.assertNotNull(sellerInfo);
    }
}