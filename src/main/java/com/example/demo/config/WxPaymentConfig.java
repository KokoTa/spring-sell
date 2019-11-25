package com.example.demo.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
@Data
@Component
public class WxPaymentConfig {

    @Autowired
    private WxAccountConfig wxAccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        WxPayConfig wxPayConfig = new WxPayConfig();
        wxPayConfig.setAppId(wxAccountConfig.getMpAppId());
        wxPayConfig.setAppSecret(wxAccountConfig.getMpAppSecret());
        wxPayConfig.setMchId(wxAccountConfig.getMchId());
        wxPayConfig.setMchKey(wxAccountConfig.getMchKey());
        wxPayConfig.setKeyPath(wxAccountConfig.getKeyPath());
        wxPayConfig.setNotifyUrl(wxAccountConfig.getNotifyUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayConfig);

        return bestPayService;
    }
}
