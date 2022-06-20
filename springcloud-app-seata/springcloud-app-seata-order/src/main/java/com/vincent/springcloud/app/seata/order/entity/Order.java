package com.vincent.springcloud.app.seata.order.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单
 * @author vincent.li
 */
@Data
public class Order {

    private String id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

}
