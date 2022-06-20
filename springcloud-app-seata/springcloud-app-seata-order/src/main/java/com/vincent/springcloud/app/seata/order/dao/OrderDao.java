package com.vincent.springcloud.app.seata.order.dao;

import com.vincent.springcloud.app.seata.order.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * @author vincent.li
 */
@Repository
public interface OrderDao {

    /**
     * 创建订单
     * @param order
     * @return
     */
    void create(Order order);
}
