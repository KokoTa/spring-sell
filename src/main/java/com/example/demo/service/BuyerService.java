package com.example.demo.service;

import com.example.demo.dto.OrderDTO;

/**
 * @author KokoTa
 * @create 2019/11/23
 */
public interface BuyerService {

    // 查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    // 取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
