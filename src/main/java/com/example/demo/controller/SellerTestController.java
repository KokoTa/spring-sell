package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@RestController
@RequestMapping("/seller")
public class SellerTestController {

    @GetMapping("/test")
    public String test() {
        return "接口测试";
    }
}
