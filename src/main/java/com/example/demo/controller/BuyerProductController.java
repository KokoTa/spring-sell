package com.example.demo.controller;

import java.util.ArrayList;
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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BuyerProductController
 */
@RestController
@RequestMapping("/buyer/product")
@CacheConfig(cacheNames = "product")
public class BuyerProductController {

  @Autowired
  private ProductService pService;

  @Autowired
  private CategoryService cService;

  @GetMapping("/list")
  // 获取列表时会进行缓存，当然，更新数据的时候需要更新缓存，需要用到 @CachePut(cacheNames = "productList", key = "123") 注解，这个注解会把返回值填到 redis 中，注意 @Cacheable 和 @CachePut 的返回值对象类型要相同
  // @CacheEvict(cacheNames = "productList", key = "123") 会先清除 redis 对应的内容，然后新增自定义对象，如果有一个更新接口只更新了列表中的某个对象，那么就应该使用 @CacheEvict
  // key 如果不填默认为传入的第一个参数，为了防止出现问题，key 我们规定必填
  // PS：动态传参：@Cacheable(key="#id", condition="#id.length() > 0 && #rest.getCode() == 0") public ResultVo<Object> list(@RequestParam("id") String id) { ... }
  @Cacheable(key = "123") // 这里把 cacheNames 提升到上面了
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