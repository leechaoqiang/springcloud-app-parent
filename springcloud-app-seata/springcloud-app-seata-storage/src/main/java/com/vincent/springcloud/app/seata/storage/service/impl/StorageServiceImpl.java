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
    public void decrease(Long productId, Integer count) {
        log.info("productId:{},count:{}------->扣减库存开始", productId, count);
        storageDao.decrease(productId,count);
        log.info("------->扣减库存结束");
    }
}
