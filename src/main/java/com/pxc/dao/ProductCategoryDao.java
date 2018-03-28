package com.pxc.dao;

import com.pxc.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    List<ProductCategory> getByCategoryTypeIn(List<Integer> categoryType);
}
