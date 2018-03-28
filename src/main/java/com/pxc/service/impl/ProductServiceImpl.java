package com.pxc.service.impl;

import com.pxc.dao.ProductInfoDao;
import com.pxc.entity.ProductInfo;
import com.pxc.enums.ProductStatus;
import com.pxc.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> getByProductStatus(Integer productStatus) {
        return productInfoDao.getByProductStatus(productStatus);
    }

    @Override
    public ProductInfo getById(String id) {
        return productInfoDao.getOne(id);
    }

    @Override
    public List<ProductInfo> getAllUp() {
        return productInfoDao.getByProductStatus(ProductStatus.up.getCode());
    }

    @Override
    public Page<ProductInfo> getAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo saveOrUpdate(ProductInfo productInfo) {
        if(StringUtils.isNotBlank(productInfo.getProductId())){
            productInfo.setCreateTime(new Date());
        }else{
            productInfo.setUpdateTime(new Date());
        }
        return productInfoDao.save(productInfo);
    }
}
