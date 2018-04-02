package com.pxc.service.impl;

import com.pxc.dao.ProductInfoDao;
import com.pxc.dto.CartDTO;
import com.pxc.entity.ProductInfo;
import com.pxc.enums.ProductStatus;
import com.pxc.enums.ResultEnum;
import com.pxc.exception.SellException;
import com.pxc.service.ProductService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
            productInfo.setUpdateTime(new Date());
        }else{
            productInfo.setCreateTime(new Date());
            productInfo.setUpdateTime(new Date());
    }
        return productInfoDao.save(productInfo);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInfo = productInfoDao.getOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);

            productInfoDao.save(productInfo);
        }
    }
}
