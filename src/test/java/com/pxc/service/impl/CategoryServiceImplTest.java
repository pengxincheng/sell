package com.pxc.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by pxc on 2018/3/27.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryService;

    @Test
    public void getById() throws Exception {
        System.out.println(categoryService.getById(1));
    }

    @Test
    public void getAll() throws Exception {
        System.out.println(categoryService.getAll());
    }

    @Test
    public void getByType() throws Exception {
        System.out.println(categoryService.getByType(Arrays.asList(1,2)));
    }

    @Test
    public void saveOrUpdate() throws Exception {
    }

}