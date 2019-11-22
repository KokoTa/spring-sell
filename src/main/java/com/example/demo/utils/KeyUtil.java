package com.example.demo.utils;

import java.util.Random;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
public class KeyUtil {

    /**
     * 生成唯一主键，为了防止多线程下有问题，需要加上 synchronized
     * 格式：时间 + 6 位随机数
     * @return
     */
    public static synchronized  String getUniqueKey() {
        Random random = new Random();

        Integer num = random.nextInt(90000) + 100000;

        return System.currentTimeMillis() + String.valueOf(num);
    }
}
