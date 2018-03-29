package com.pxc.dao;

import com.pxc.entity.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by pxc on 2018/3/29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Test
    public void getByProductStatus() throws Exception {
    }


    @Test
    public void save(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductName("随着");
        productInfo.setCreateTime(new Date());
        productInfo.setCategoryType(1);
        productInfoDao.save(productInfo);

    }
}