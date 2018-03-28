package com.pxc.dao;

import com.pxc.entity.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * Created by pxc on 2018/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Test
    public void testFindAll(){
        System.out.println(123);
        System.out.println(productCategoryDao.findAll().toString());
    }

    @Test
    public void testSave(){
        ProductCategory p = new ProductCategory();
        p.setCategoryName("女生最爱");
        p.setCategoryType(2);
        p.setCreateTime(new Date());
        productCategoryDao.save(p);
    }

    @Test
    @Transactional
    public void testUpdate(){
        ProductCategory p = productCategoryDao.getOne(1);
        p.setCategoryName("男生最爱");
        p.setUpdateTime(new Date());
        productCategoryDao.save(p);
    }

    @Test
    public void testGetByType(){
        List<ProductCategory> p = productCategoryDao.getByCategoryTypeIn(Arrays.asList(1,2));
        System.out.println(p.toString());
    }
}