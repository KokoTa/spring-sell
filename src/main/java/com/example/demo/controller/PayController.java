package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.OrderService;
import com.example.demo.service.PayService;
import com.example.demo.utils.MathUtil;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
@RestController
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public PayResponse create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl) {

        // 1 查询订单
        OrderDTO orderDTO = orderService.findOne("1574408108620149070");

        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        // 2 发起支付
        PayResponse payResponse = payService.create(orderDTO);

        // 3 返回给前端发起支付请求
        return payResponse;
    }

    @PostMapping("/notify")
    // notifyData 传进来的时候是 xml 格式的
    public String notify(@RequestBody String notifyData) {

        // 接收支付成功后的数据并修改订单
        PayResponse payResponse = payService.notify(notifyData);

        // 发送通知给微信，不再触发异步通知
        String returnData = "....";

        return returnData;
    }

    @PostMapping("/refund")
    public String refund(@RequestParam("orderId") String orderId) {
        // ... 代码略
        return "OK";
    }

}
