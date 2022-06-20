package com.vincent.springcloud.app.seata.account.dao;

import java.math.BigDecimal;
import org.apache.ibatis.annotations.Param;

/**
 * @author vincent.li
 */
public interface AccountDao {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return int
     */
    int decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);

    /**
     * 查询账户余额
     * @param userId 用户id
     * @return BigDecimal
     */
    BigDecimal queryBalanceByUserId(@Param("userId") Long userId);
}
