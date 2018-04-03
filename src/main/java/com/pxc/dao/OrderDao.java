package com.pxc.dao;

import com.pxc.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pxc on 2018/4/2.
 */
public interface OrderDao extends JpaRepository<Order,String> {

    Page<Order> findByBuyerOpenid(String openId, Pageable pageable);

    Order findByBuyerOpenidAndOrderId(String buyerOpenid,String orderId);
}
