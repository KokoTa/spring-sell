package com.example.demo.service.impl;

import com.example.demo.dto.OrderDTO;
import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.OrderService;
import com.example.demo.service.PayService;
import com.example.demo.utils.JsonUtil;
import com.example.demo.utils.MathUtil;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundRequest;
import com.lly835.bestpay.model.RefundResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    private BestPayServiceImpl bestPayService;

    @Autowired
    private OrderService orderService;

    private static final String ORDER_NAME = "订单";

    /**
     * 订单支付
     * @param orderDTO
     * @return
     */
    @Override
    public PayResponse create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();

        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_MWEB);
        log.info("[微信支付]: 发起支付, payRequest={}", JsonUtil.toJson(payRequest));

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("[微信支付]: 发起支付, payResponse={}", JsonUtil.toJson(payResponse));

        // 重定向到 pay.html 来进行支付
        return payResponse;
    }

    /**
     * 订单处理
     * @param notifyData
     * @return
     */
    @Override
    public PayResponse notify(String notifyData) {
        // 订单提交后的异步通知
        PayResponse payResponse = bestPayService.asyncNotify(notifyData);
        log.info("[微信支付]：异步通知, payResponse={}", payResponse);

        // 修改数据库订单状态
        // 修改订单状态前需要：
        // 验证返回的签名是否是微信的签名、验证返回的支付状态、验证返回的金额、验证下单人和支付人是否一致(可选)
        // 第一点和第二点 SDK 已经做了，主要验证第三点
        OrderDTO orderDTO = orderService.findOne(payResponse.getOrderId());

        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        if (MathUtil.equals(payResponse.getOrderAmount(), orderDTO.getOrderAmount().doubleValue())) {
            throw new SellException(ResultEnum.ORDER_PAY_AMOUNT_ERROR);
        }

        orderService.paid(orderDTO);

        // 将订单结果返还给微信，告诉微信不要再发异步通知了，但不推荐放在这里，应该放在 Controller 里

        return payResponse;
    }

    /**
     * 订单退款
     * @param orderDTO
     */
    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        RefundRequest refundRequest = new RefundRequest();
        refundRequest.setOrderId(orderDTO.getOrderId());
        refundRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        refundRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_MWEB);

        RefundResponse refundResponse = bestPayService.refund(refundRequest);

        return refundResponse;
    }
}
