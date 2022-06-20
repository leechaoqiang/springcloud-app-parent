package com.vincent.springcloud.app.seata.account.service.impl;


import java.math.BigDecimal;

import com.vincent.springcloud.app.seata.account.dao.AccountDao;
import com.vincent.springcloud.app.seata.account.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Resource
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {
        LOGGER.info("------->扣减账户开始account中");
//        try {
//            Thread.sleep(30*1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountDao.decrease(userId,money);
        LOGGER.info("------->扣减账户结束account中");
    }
}
