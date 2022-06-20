package com.vincent.springcloud.app.seata.account.controller;

import java.math.BigDecimal;


import com.vincent.springcloud.app.seata.account.service.AccountService;
import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
/**
 * @author vincent.li
 */
@RestController
@RequestMapping("account")
public class AccountController {

    @Resource
    private AccountService accountServiceImpl;

    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     * @return
     */
    @RequestMapping("decrease")
    public Response<Boolean> decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        accountServiceImpl.decrease(userId,money);
        return Response.buildSuccess(Boolean.TRUE);

    }
}
