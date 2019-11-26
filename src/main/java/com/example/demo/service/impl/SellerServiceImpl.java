package com.example.demo.service.impl;

import com.example.demo.dao.SellerInfoRepository;
import com.example.demo.entity.SellerInfo;
import com.example.demo.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository repository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return repository.findByOpenid(openid);
    }
}
