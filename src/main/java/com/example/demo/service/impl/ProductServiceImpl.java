package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.ProductInfoRepository;
import com.example.demo.dto.CartDTO;
import com.example.demo.entity.ProductInfo;
import com.example.demo.enums.ProductStatusEnum;
import com.example.demo.exception.ResultEnum;
import com.example.demo.exception.SellException;
import com.example.demo.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;

/**
 * ProductServiceImpl
 */
@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductInfoRepository repository;

  @Override
  public ProductInfo findOne(String productId) {
    Optional<ProductInfo> p = repository.findById(productId);

    if (p.isPresent()) {
      return p.get();
    }

    return null;
  }

  @Override
  public List<ProductInfo> findUpAll() {
    return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
  }

  @Override
  public Page<ProductInfo> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Override
  public ProductInfo save(ProductInfo productInfo) {
    return repository.save(productInfo);
  }

  @Override
  public void increaseStock(List<CartDTO> cartDTOList) {
    /**
     * findById 会返回 Optional对象，除了下面的写法，还可以这样写：
     * repository.findById(cartDTO.getProductId()).orElse(null)
     */
    for (CartDTO cartDTO: cartDTOList) {
      Optional<ProductInfo> opt = repository.findById(cartDTO.getProductId());
      if (opt.isPresent()) {
         ProductInfo productInfo = opt.get();
         Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();

        productInfo.setProductStock(result);
        repository.save(productInfo);
      } else {
        throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
      }
    }
  }

  @Override
  public void decreaseStock(List<CartDTO> cartDTOList) {
    for (CartDTO cartDTO : cartDTOList) {
      Optional<ProductInfo> opt = repository.findById(cartDTO.getProductId());
      if (opt.isPresent()) {
        ProductInfo productInfo = opt.get();
        Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();

        if (result < 0) {
          throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
        }

        productInfo.setProductStock(result);
        repository.save(productInfo);
      } else {
        throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
      }
    }
  }

}