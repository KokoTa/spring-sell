package com.example.demo.controller;

import com.example.demo.exception.SellException;
import com.example.demo.service.RedisLock;
import com.example.demo.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟并发订单
 * 测试代码：ab -n 100 -c 100 http://localhost:8080/sell/count
 * 并发模式下会出现 count 不会等于 900 的问题，此时用 synchronized 可以解决，但是由于是同步锁操作，因此会发现很卡
 * @author KokoTa
 * @create 2019/11/27
 */
@RestController
public class SyncController {

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10 * 1000; // 10s

    private String productId = "productId"; // 模拟一个商品

    private int TOTAL = 1000;

    private int count = TOTAL;

    @GetMapping("/count")
    String count() {
        // 加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId, String.valueOf(time))) {
            throw new SellException(101, "抢不到锁啊！");
        }

        // 并发下会出现读取同一个 count 值的情况，造成问题
        try {
            Thread.sleep(100); // 模拟耗时
            count--;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 解锁
        redisLock.unlock(productId, String.valueOf(time));

        return TOTAL + " " + count;
    }
}
