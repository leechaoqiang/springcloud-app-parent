package com.vincent.springcloud.app.seata.storage.service.impl;

import com.vincent.springcloud.app.seata.storage.dao.StorageDao;
import com.vincent.springcloud.app.seata.storage.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Slf4j
@Service("storageServiceImpl")
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @Override
    public boolean decrease(Long productId, Integer count) {
        log.info("decrease#productId:{},count:{}------->扣减库存开始", productId, count);
        int balance = storageDao.queryBalance(productId);
        if (count >  balance) {
            log.info("decrease#productId:{},count:{},balance:{}------->扣减库存失败，库存不足", productId, count, balance);
            throw new RuntimeException("商品库存不足");
        }
        int decFlag = storageDao.decrease(productId,count);
        if (decFlag <= 0) {
            log.info("decrease#productId:{},count:{},balance:{}------->扣减库存失败", productId, count, balance);
            return Boolean.FALSE;
        }
        log.info("decrease------->扣减库存结束");
        return Boolean.TRUE;
    }
}
