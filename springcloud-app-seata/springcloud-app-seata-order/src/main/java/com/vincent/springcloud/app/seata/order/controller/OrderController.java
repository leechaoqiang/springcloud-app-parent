package com.vincent.springcloud.app.seata.order.controller;

import com.vincent.springcloud.app.seata.order.entity.Order;
import com.vincent.springcloud.app.seata.order.service.OrderService;
import com.vincent.springcloud.seata.common.enums.ResponseCodeEnum;
import com.vincent.springcloud.seata.common.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Slf4j
@RestController
@RequestMapping(value = "order")
public class OrderController {

    @Resource
    private OrderService orderServiceImpl;

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    @GetMapping("/create")
    public Response<Boolean> create(Order order) {
        try {
            orderServiceImpl.create(order);
        } catch (Exception e) {
            log.error("创建订单失败", e);
            return Response.buildFailure(ResponseCodeEnum.FAIL.getCode(), "创建订单失败:".concat(e.getMessage()));
        }
        return Response.buildSuccess(Boolean.TRUE, "创建订单成功");

    }
}
