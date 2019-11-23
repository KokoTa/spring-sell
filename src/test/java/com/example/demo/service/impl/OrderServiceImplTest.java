package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.OrderMaster;
import com.example.demo.enums.OrderStatusEnum;
import com.example.demo.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl service;

    private final String OPENID = "openid";

    private final String ORDERID = "1574408108620149070";

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress("YY街道");
        orderDTO.setBuyerName("Brain");
        orderDTO.setBuyerOpenid(OPENID);
        orderDTO.setBuyerPhone("15274837465");

        // 购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail od = new OrderDetail();
        od.setProductId("1111");
        od.setProductQuantity(10);
        orderDetailList.add(od);
        OrderDetail od2 = new OrderDetail();
        od2.setProductId("1234");
        od2.setProductQuantity(10);
        orderDetailList.add(od2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = service.create(orderDTO);
        log.info("[创建订单]： result={}", result);
    }

    @Test
    void findOne() {
        OrderDTO result = service.findOne(ORDERID);
        log.info("[查询订单]：result={}", result);
    }

    @Test
    void findList() {
        PageRequest request = PageRequest.of(0, 10);
        Page<OrderDTO> orderDTOList = service.findList("openid", request);
        log.info("[查询订单列表]: result={}", orderDTOList.getTotalElements());
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = service.findOne(ORDERID);
        OrderDTO result = service.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    void finish() {
        OrderDTO orderDTO = service.findOne(ORDERID);
        OrderDTO result = service.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    void paid() {
        OrderDTO orderDTO = service.findOne(ORDERID);
        OrderDTO result = service.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}