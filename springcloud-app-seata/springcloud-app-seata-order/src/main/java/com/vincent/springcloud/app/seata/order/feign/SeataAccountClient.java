package com.vincent.springcloud.app.seata.order.feign;

import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author vincent.li
 */
@FeignClient(value = "${seata.account.remote.service:SPRINGCLOUD-APP-SEATA-ACCOUNT}")
public interface SeataAccountClient {

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @RequestMapping("/account/decrease")
    Response<Boolean> decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money);
}
