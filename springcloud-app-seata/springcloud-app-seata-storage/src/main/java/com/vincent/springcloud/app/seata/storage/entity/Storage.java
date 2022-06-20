package com.vincent.springcloud.app.seata.storage.entity;

import lombok.Data;

/**
 * @author vincent.li
 */
@Data
public class Storage {

    private Long id;

    /**产品id*/
    private Long productId;

    /**总库存*/
    private Integer total;

    /**已用库存*/
    private Integer used;

    /**剩余库存*/
    private Integer balance;
}
