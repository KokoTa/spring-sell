package com.example.demo.dto;

import lombok.Data;

/**
 * @author KokoTa
 * @create 2019/11/22
 */
@Data
public class CartDTO {

    // 商品 id
    private String productId;

    // 商品数量
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
