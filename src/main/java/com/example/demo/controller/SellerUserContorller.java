package com.example.demo.controller;

import com.example.demo.constant.CookieConstant;
import com.example.demo.constant.RedisConstant;
import com.example.demo.entity.SellerInfo;
import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.SellerService;
import com.example.demo.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@RestController
@RequestMapping("/seller")
public class SellerUserContorller {

    @Autowired
    private SellerService service;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/login")
    public String login(@RequestParam("openid") String openid, HttpServletResponse response) {
        // openid 和 数据库去匹配
        SellerInfo sellerInfo = service.findSellerInfoByOpenid(openid);

        if (sellerInfo == null) {
            throw new SellException(ResultEnum.LOGIN_FAIL);
        }

        // 设置 token 到 redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;

        stringRedisTemplate.opsForValue().set(RedisConstant.TOKEN_PREFIX + token, openid, expire, TimeUnit.SECONDS);

        // 设置 token 到 cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, expire);

        return "登录成功";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                       HttpServletResponse response) {
        // 从 cookie 里查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        // 清除 redis
         if (cookie != null) {
            stringRedisTemplate.opsForValue().getOperations().delete(RedisConstant.TOKEN_PREFIX + cookie.getValue());
        }

        // 清除 cookie
        CookieUtil.set(response, CookieConstant.TOKEN, null, 0);

         return "登出成功";
    }
}
