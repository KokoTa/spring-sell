package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.BuyerService;
import com.example.demo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KokoTa
 * @create 2019/11/23
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {

        OrderDTO orderDTO = checkOrderOwner(openid, orderId);

        if (orderDTO == null) {
            log.error("[查询订单]：查询不到该订单, orderid={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);

        if (orderDTO == null) {
            return null;
        }

        if (!orderDTO.getBuyerOpenid().equals(openid)) {
            log.error("[查询订单]：openid不一致, orderid={}, orderDTO={}", orderId, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
