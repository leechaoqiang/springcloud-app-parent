package com.vincent.springcloud.app.seata.storage.service;

/**
 * @author vincent.li
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    boolean decrease(Long productId, Integer count);
}
