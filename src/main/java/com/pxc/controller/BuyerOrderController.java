package com.pxc.controller;

import com.pxc.dto.OrderDTO;
import com.pxc.enums.ResultEnum;
import com.pxc.exception.SellException;
import com.pxc.form.OrderForm;
import com.pxc.service.OrderService;
import com.pxc.utils.ConvertUtil;
import com.pxc.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pxc on 2018/4/2.
 */
@RestController
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(BuyerOrderController.class);

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/create")
    public Response createOrder(@Valid OrderForm orderForm,
                                BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = ConvertUtil.convertOrderForm2OrderDTO(orderForm);
        if (null == orderDTO.getOrderDetailList() || orderDTO.getOrderDetailList().size() <= 0) {
            logger.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }

        Map<String,String> resultData = new HashMap<>();
        resultData.put("orderId",orderService.createOrder(orderDTO));
        return Response.ok(resultData);
    }

    @GetMapping("detail/")
    public Response getOrderDetail(){


        return Response.ok();
    }

}
