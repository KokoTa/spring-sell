package com.example.demo.controller;

import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KokoTa
 * @create 2019/12/3
 */
@RestController
public class TestController {

    @Autowired
    User user;

    @GetMapping("/getUser")
    Integer getUser () {

        return 1/0;
    }
}
