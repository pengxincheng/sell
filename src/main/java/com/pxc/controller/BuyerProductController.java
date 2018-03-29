package com.pxc.controller;

import com.pxc.dao.ProductCategoryDao;
import com.pxc.dao.ProductInfoDao;
import com.pxc.entity.ProductCategory;
import com.pxc.entity.ProductInfo;
import com.pxc.utils.Response;
import com.pxc.vo.ProductInfoVo;
import com.pxc.vo.ProductVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 买家商品接口
 * Created by z on 2018/3/28.
 */
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {
    private final Logger logger = LoggerFactory.getLogger(BuyerProductController.class);
    @Autowired
    private ProductInfoDao productInfoDao;
    @Autowired
    private ProductCategoryDao productCategoryDao;

    /**
     * 获取商品列表
     *
     * @return
     */
    @GetMapping("/list")
    public Response list() {
        try {
            List<ProductInfo> productInfoList = productInfoDao.findAll();
            List<Integer> categoryTypeList = productInfoList.parallelStream().map(productInfo -> productInfo.getCategoryType()).collect(Collectors.toList());
            List<ProductCategory> productCategoryList = productCategoryDao.getByCategoryTypeIn(categoryTypeList);

            List<ProductVo> productVoList = new ArrayList<>();

            productCategoryList.forEach(p ->{
                ProductVo productVo = new ProductVo();
                List<ProductInfoVo> productInfoVoList = new ArrayList<>();
                productVo.setCategoryName(p.getCategoryName());
                productVo.setCategoryTyep(p.getCategoryType());
                productInfoList.forEach(productInfo -> {
                    if(p.getCategoryType() == productInfo.getCategoryType()){
                        ProductInfoVo pvo = new ProductInfoVo();
                        BeanUtils.copyProperties(productInfo,pvo);
                        productInfoVoList.add(pvo);
                    }
                });
                productVo.setProductInfoVoList(productInfoVoList);
                productVoList.add(productVo);
            });

            return Response.ok(productVoList);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Response.error();
        }
    }

}
