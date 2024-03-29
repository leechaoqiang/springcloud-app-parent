package com.vincent.springcloud.app.seata.account.service;

import java.math.BigDecimal;

/**
 * @author vincent.li
 */
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    boolean decrease(Long userId, BigDecimal money);
}
