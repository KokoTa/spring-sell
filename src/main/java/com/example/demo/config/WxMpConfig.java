package com.example.demo.config;

import lombok.Data;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.WxMpConfigStorage;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
@Data
@Component
public class WxMpConfig {

    @Autowired
    private WxAccountConfig wxAccountConfig;

    // @Bean 会把这个方法注入到 IOC 中，@Autowired 时会进行匹配
    @Bean
    public WxMpService wxMpService() {
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxMpConfigStorage());
        return wxMpService;
    }

    @Bean
    public WxMpConfigStorage wxMpConfigStorage() {
        WxMpDefaultConfigImpl wxMpConfigStorage = new WxMpDefaultConfigImpl();
        wxMpConfigStorage.setAppId(wxAccountConfig.getMpAppId());
        wxMpConfigStorage.setSecret(wxAccountConfig.getMpAppSecret());

        return wxMpConfigStorage;
    }
}
