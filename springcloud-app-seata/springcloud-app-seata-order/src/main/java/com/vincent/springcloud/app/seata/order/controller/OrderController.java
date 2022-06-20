package com.vincent.springcloud.app.seata.order.controller;

import com.vincent.springcloud.app.seata.order.entity.Order;
import com.vincent.springcloud.app.seata.order.service.OrderService;
import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vincent.li
 */
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Autowired
    private OrderService orderServiceImpl;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @GetMapping("create")
    public Response<Boolean> create(Order order){
        orderServiceImpl.create(order);
        return Response.buildSuccess(Boolean.TRUE);

    }
}
