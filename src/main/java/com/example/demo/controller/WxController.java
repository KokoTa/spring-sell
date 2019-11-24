package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KokoTa
 * @create 2019/11/24
 */
@RestController
@RequestMapping("/wx")
@Slf4j
public class WxController {

    @GetMapping("/auth")
    public Object auth(@RequestParam("code") String code) {
        log.info("[微信授权]：code={}", code);
        return null;
    }
}
