package com.vincent.springcloud.app.seata.storage.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author vincent.li
 */
@Repository
public interface StorageDao {
    /**
     * 查询库存余额
     * @param productId 产品id
     * @return BigDecimal
     */
    int queryBalance(@Param("productId") Long productId);
    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    int decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
