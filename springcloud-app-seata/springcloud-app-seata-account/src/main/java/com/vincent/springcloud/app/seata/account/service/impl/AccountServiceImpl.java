package com.vincent.springcloud.app.seata.account.service.impl;

import java.math.BigDecimal;

import com.vincent.springcloud.app.seata.account.dao.AccountDao;
import com.vincent.springcloud.app.seata.account.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@Slf4j
@Service("accountServiceImpl")
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    /**
     * 扣减账户余额
     *
     * @param userId 用户id
     * @param money  金额
     */
    @Override
    public boolean decrease(Long userId, BigDecimal money) {
        log.info("扣减账户余额#userId:{},money:{}------->扣减账户开始account中", userId, money);
        BigDecimal balance = accountDao.queryBalanceByUserId(userId);
        if (balance.compareTo(money) < 0) {
            log.info("扣减账户余额#userId:{},money:{},balance:{}------->扣减账户失败,账号余额不足", userId, money, balance);
            throw new RuntimeException("账户余额不足");
        }
        int succ = accountDao.decrease(userId, money);
        if (succ <= 0) {
            log.info("扣减账户余额#userId:{},money:{},balance:{}------->扣减账户失败", userId, money, balance);
            return Boolean.FALSE;
        }
        log.info("扣减账户余额操作成功------->扣减账户结束account中");
        return Boolean.TRUE;
    }
}
