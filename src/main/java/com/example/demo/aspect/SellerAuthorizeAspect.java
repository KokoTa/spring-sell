package com.example.demo.aspect;

import com.example.demo.constant.CookieConstant;
import com.example.demo.constant.RedisConstant;
import com.example.demo.exception.AspectException;
import com.example.demo.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@Aspect
@Component
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 不会拦截登录登出，但会拦截 SellerTest
    // 抛出自定义的 AspectException 后会被 AspectExceptionHandler 拦截
    @Pointcut("execution(public * com.example.demo.controller.Seller*.*(..))" +
            " && !execution(public * com.example.demo.controller.SellerUserContorller.*(..))")
    public void verify() {}

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 查询 cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);

        if (cookie == null) {
            throw new AspectException(44, "请求未携带 token");
        }

        // 查询 redis
        String tokenValue = stringRedisTemplate.opsForValue().get(RedisConstant.TOKEN_PREFIX + cookie.getValue());

        if (StringUtils.isEmpty(tokenValue)) {
            throw new AspectException(44, "redis 中没有对应键");
        }
    }
}
