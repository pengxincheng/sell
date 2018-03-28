package com.pxc.dao;

import com.pxc.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> getByProductStatus(Integer productStatus);
}
