package com.example.demo.dao;

import com.example.demo.entity.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KokoTa
 * @create 2019/11/26
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
}
