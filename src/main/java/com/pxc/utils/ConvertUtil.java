package com.pxc.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pxc.dto.OrderDTO;
import com.pxc.entity.Order;
import com.pxc.entity.OrderDetail;
import com.pxc.enums.ResultEnum;
import com.pxc.exception.SellException;
import com.pxc.form.OrderForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by pxc on 2018/4/2.
 */
public class ConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(ConvertUtil.class);

    /**
     * order转orderDTO
     * @param orderList
     * @return
     */
    public static List<OrderDTO> convertOrder2OrderDTO(List<Order> orderList) {
        return orderList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }


    /**
     * orderForm转orderDTO
     * @param orderForm
     * @return
     */
    public static OrderDTO convertOrderForm2OrderDTO(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        } catch (Exception e) {
            logger.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }


    public static OrderDTO convert(Order order) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(order, orderDTO);
        return orderDTO;
    }
}
