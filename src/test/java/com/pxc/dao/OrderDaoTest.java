package com.pxc.dao;

import com.pxc.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by pxc on 2018/4/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void findByBuyerOpenId() throws Exception {
    }

    @Test
    public void save() throws Exception {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        orderDao.save(order);
    }

    @Test
    public void getByOpenId() {


        Page<Order> orders = orderDao.findByBuyerOpenid("123", PageRequest.of(0, 10));
        System.out.println(orders.getContent().toString());
    }
}