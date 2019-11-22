package com.example.demo.dao;

import com.example.demo.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1111");
        orderDetail.setOrderId("2222");
        orderDetail.setProductIcon("http://xxx.com");
        orderDetail.setProductId("3333");
        orderDetail.setProductName("白粥");
        orderDetail.setProductPrice(new BigDecimal(20.2));
        orderDetail.setProductQuantity(2);

        orderDetail = repository.save(orderDetail);

        Assert.assertNotNull(orderDetail);
    }

    @Test
    void findByOrderId() {
        List<OrderDetail> list = repository.findByOrderId("2222");
        Assert.assertNotEquals(0, list.size());
    }
}