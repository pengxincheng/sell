package com.pxc.service;

import com.pxc.entity.ProductCategory;

import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
public interface CategoryService {

    ProductCategory getById(Integer categoryId);

    List<ProductCategory> getAll();

    List<ProductCategory> getByType(List<Integer> categoryType);

    ProductCategory saveOrUpdate(ProductCategory productCategory);
}
