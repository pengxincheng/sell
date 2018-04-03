package com.pxc.service;

import com.pxc.dto.OrderDTO;


/**
 * Created by pxc on 2018/4/2.
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
     String createOrder(OrderDTO orderDTO);

    /**
     * 查询单个订单
     * @param orderId
     * @return
     */
    OrderDTO getOrderById(String orderId);

    OrderDTO getOrderDetail(String openid,String orderId);
}
