package com.pxc.service;

import com.pxc.dto.CartDTO;
import com.pxc.entity.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
public interface ProductService {

    List<ProductInfo> getByProductStatus(Integer productStatus);

    ProductInfo getById(String id);

    /**
     * 所有上架商品
     * @return
     */
    List<ProductInfo> getAllUp();

    Page<ProductInfo> getAll(Pageable pageable);

    ProductInfo saveOrUpdate(ProductInfo productInfo);

    //加库存
    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);
}
