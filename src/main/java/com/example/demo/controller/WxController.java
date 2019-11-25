package com.example.demo.controller;

import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.bean.WxAccessToken;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 获取 openid 基本步骤为：
 * 1. 内网穿透
 * 2. 公众号验证
 * 3. 设置网页授权地址
 * 4. 获取 code
 * 5. 获取 access_token
 * 6. 获取 openid
 *
 * 不重复造轮子，上面得方法可以用 SDK 来简化：https://github.com/Wechat-Group/WxJava
 * 支付方面使用另外的 SDK 来简化：https://github.com/Pay-Group/best-pay-sdk
 *
 * 注意这里我们使用 Controller，而不是 ResetController
 * @author KokoTa
 * @create 2019/11/24
 */
@Controller
@RequestMapping("/wx")
@Slf4j
public class WxController {

    @Autowired
    private WxMpService wxMpService;

    @GetMapping("/auth")
    public String auth(@RequestParam("returnUrl") String returnUrl) throws UnsupportedEncodingException {
        // 1 配置见 config
        // 2 调用授权方法
        String url = "http://myapp.com/userInfo";
        String redirectUrl = wxMpService.oauth2buildAuthorizationUrl(url, WxConsts.OAuth2Scope.SNSAPI_USERINFO, URLEncoder.encode(returnUrl, "utf8"));
        log.info("[微信网页授权] 获取 code, redirectUrl={}", redirectUrl);
        // 3 重定向得到 code
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/userInfo")
    public String userInfo(@RequestParam("code") String code,
                         @RequestParam("state") String returnUrl) {
        WxMpOAuth2AccessToken accessToken = new WxMpOAuth2AccessToken();
        try {
            // 4 获取 access_token
           accessToken  = wxMpService.oauth2getAccessToken(code);
        } catch (WxErrorException e) {
            log.error("[微信网页授权] {}", e);
            throw new SellException(ResultEnum.WX_MP_ERROR.getCode(), e.getError().getErrorMsg());
        }
        // 5 获取 openid
        String openid = accessToken.getOpenId();

        // 6 重定向让目标页获取到 openid
        return "redirect:" + returnUrl + "?openid=" + openid;
    }
}
