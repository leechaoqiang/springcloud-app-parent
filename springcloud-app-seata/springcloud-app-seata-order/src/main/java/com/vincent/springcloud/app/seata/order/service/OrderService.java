package com.vincent.springcloud.app.seata.order.service;

import com.vincent.springcloud.app.seata.order.entity.Order;

/**
 * @author vincent.li
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);
}
