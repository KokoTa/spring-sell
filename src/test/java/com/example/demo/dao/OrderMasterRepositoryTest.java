package com.example.demo.dao;

import com.example.demo.entity.OrderMaster;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "111111";

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123124");
        orderMaster.setBuyerName("订单2");
        orderMaster.setBuyerPhone("12312312312");
        orderMaster.setBuyerAddress("xxx街道");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(512.3));

        OrderMaster res = repository.save(orderMaster);

        Assert.assertNotNull(res);
    }

    @Test
    void findByBuyerOpenid() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderMaster> res = repository.findByBuyerOpenid(OPENID, request);
        Assert.assertNotEquals(0, res.getContent().size());
    }
}