package com.example.demo.service;

import com.example.demo.entity.SellerInfo;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
public interface SellerService {

    SellerInfo findSellerInfoByOpenid(String openid);
}
