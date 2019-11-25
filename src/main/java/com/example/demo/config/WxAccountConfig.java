package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WxAccountConfig {

    // app id
    private String mpAppId;

    // app密钥
    private String mpAppSecret;

    // 商户号
    private String mchId;

    // 商户密钥
    private String mchKey;

    // 商户证书路径
    private String keyPath;

    // 支付异步通知地址
    private String notifyUrl;

}
