package com.example.demo.utils;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.000001;

    public static Boolean equals(Double d1, Double d2) {
        Double result = Math.abs(d1 - d2);

        return result < MONEY_RANGE;
    }
}
