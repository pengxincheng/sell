package com.pxc.service.impl;

import com.pxc.dao.ProductCategoryDao;
import com.pxc.entity.ProductCategory;
import com.pxc.service.CategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by pxc on 2018/3/27.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory getById(Integer categoryId) {
        return productCategoryDao.getOne(categoryId);
    }

    @Override
    public List<ProductCategory> getAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> getByType(List<Integer> categoryType) {
        return productCategoryDao.getByCategoryTypeIn(categoryType);
    }

    @Override
    public ProductCategory saveOrUpdate(ProductCategory productCategory) {
        if(null != productCategory.getCategoryId()){
            productCategory.setUpdateTime(new Date());
        }else {
            productCategory.setUpdateTime(new Date());
            productCategory.setCreateTime(new Date());
        }
        return productCategoryDao.save(productCategory);
    }
}
