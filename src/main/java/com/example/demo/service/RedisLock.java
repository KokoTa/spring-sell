package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author KokoTa
 * @create 2019/11/27
 */
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key productId，用来作为锁
     * @param value 当前时间 + 超时时间，可以当作线程
     * @return
     */
    public boolean lock(String key, String value) {
        // 如果没有锁，那么就加一把锁，表示该线程拿到了锁
        if (redisTemplate.opsForValue().setIfAbsent(key, value)) {
            return true;
        }

        // 获取当前锁的线程
        String currentValue = redisTemplate.opsForValue().get(key);

        // 这里的代码用于防止死锁
        // 如果线程过期(超时)
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()) {

            /**
             * 解析：假设我有 a b c 三个线程
             * a 首先进入并获取到这个锁，即执行了开头代码
             * 随后 b c 一起进入了代码，跳过了开头代码，获取了 currentValue 为 a
             * 假设 a 已经过期了
             * 那么 b c 一起进入这个判断
             * 虽然说是一起进入，但必定会有一个先获取 oldValue
             * 假设 b 先获取了 oldValue
             * 那么 oldValue 值为 a，key 赋值为 b，b 拿到了锁
             * 至此，好像没问题了，但是如果 c 也执行了这句代码，那么就是 c 拿到了锁
             * 为了只让 b 获取这把锁，需要再进行下面的判断
             * currentValue 表示已经过期的那个线程，而 oldValue 表示被替换的那个线程
             * 如果二者相等，那就意味着执行这句代码的线程拿到了锁，即先到先得
             * 为什么是先到先得？
             * 现在 b 拿到了锁，此时再来看看 c
             * c 执行了这句代码，拿到的 oldValue 是 b
             * a 和 b 不相等，意味着 b 先拿到锁了，所以 c 就没戏了
             */

            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);

            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)) {
                return true;
            }
        }

        // 线程没有拿到锁
        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value) {
        String currentValue = redisTemplate.opsForValue().get(key);

        // 解锁就是删除键值对，表示这个 productId 的操作结束了
        if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)) {
            redisTemplate.opsForValue().getOperations().delete(key);
        }
    }
}
