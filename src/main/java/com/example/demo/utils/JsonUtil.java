package com.example.demo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author KokoTa
 * @create 2019/11/25
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
