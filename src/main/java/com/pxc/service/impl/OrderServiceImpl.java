package com.pxc.service.impl;

import com.pxc.dao.OrderDao;
import com.pxc.dao.OrderDetailDao;
import com.pxc.dto.CartDTO;
import com.pxc.dto.OrderDTO;
import com.pxc.entity.Order;
import com.pxc.entity.OrderDetail;
import com.pxc.entity.ProductInfo;
import com.pxc.enums.OrderStatus;
import com.pxc.enums.PayStatus;
import com.pxc.enums.ResultEnum;
import com.pxc.exception.SellException;
import com.pxc.service.OrderService;
import com.pxc.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pxc on 2018/4/2.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderDao orderDao;

    @Override
    @Transactional
    public String createOrder(OrderDTO orderDTO) {
        //5.发消息
        Order order = new Order();
        order.newOrderId();
        orderDTO.setOrderId(order.getOrderId());
        BigDecimal orderAmount = new BigDecimal(0);
        List<OrderDetail> orderDetailList = orderDTO.getOrderDetailList();
        for (OrderDetail o : orderDetailList) {
            //1.计算总价
            ProductInfo productInfo = productService.getById(o.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(o.getProductQuantity())).add(orderAmount);

            //2.详情入库
            OrderDetail orderDetail = new OrderDetail();
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetail.setOrderId(order.getOrderId());
            orderDetailDao.save(orderDetail);
        }
        //3.订单入库
        BeanUtils.copyProperties(orderDTO,order);
        order.setCreateTime(new Date());
        order.setUpdateTime(new Date());
        order.setOrderAmount(orderAmount);
        order.setOrderStatus(OrderStatus.NEW.getCode());
        order.setPayStatus(PayStatus.WAIT.getCode());
        orderDao.save(order);
        //4.减库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
        ).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);
        return order.getOrderId();
    }
}
