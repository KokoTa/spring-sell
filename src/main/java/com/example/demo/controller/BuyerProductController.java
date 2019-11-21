package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.entity.ProductCategory;
import com.example.demo.entity.ProductInfo;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.utils.ResultVoUtil;
import com.example.demo.vo.ProductInfoVo;
import com.example.demo.vo.ProductVo;
import com.example.demo.vo.ResultVo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BuyerProductController
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

  @Autowired
  private ProductService pService;

  @Autowired
  private CategoryService cService;

  @GetMapping("/list")
  public ResultVo<Object> list() {

    // 1. 查询所有上架的商品
    List<ProductInfo> piList = pService.findUpAll();

    // 2. 查询类目(一次性查询)
    List<Integer> categoryTypeList = new ArrayList<>();
    categoryTypeList = piList.stream().map(e -> e.getCategoryType()).collect(Collectors.toList()); // 通过 lambda 进行过滤
    List<ProductCategory> pcList = cService.findByCategoryTypeIn(categoryTypeList);

    // 3. 数据拼装
    List<ProductVo> pvoList = new ArrayList<>();

    for (ProductCategory pc : pcList) {
      ProductVo pvo = new ProductVo();
      pvo.setCategoryType(pc.getCategoryType());
      pvo.setCategoryName(pc.getCategoryName());

      List<ProductInfoVo> pivoList = new ArrayList<>();

      for (ProductInfo pi : piList) {
        if (pi.getCategoryType().equals(pc.getCategoryType())) {
          ProductInfoVo pivo = new ProductInfoVo();
          // 拷贝属性
          BeanUtils.copyProperties(pi, pivo);
          pivoList.add(pivo);
        }
      }

      pvo.setProductInfoVosList(pivoList);
      pvoList.add(pvo);
    }

    return ResultVoUtil.success(pvoList);
  }
}