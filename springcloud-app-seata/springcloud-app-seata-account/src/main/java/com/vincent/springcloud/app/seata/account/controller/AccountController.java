package com.vincent.springcloud.app.seata.account.controller;

import java.math.BigDecimal;
import java.util.Objects;

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
    @RequestMapping("/decrease")
    public Response<Boolean> decrease(@RequestParam("userId") Long userId,@RequestParam("money") BigDecimal money){
        if (Objects.isNull(userId) || Objects.isNull(money)) {
            return Response.buildFailure("请求参数：用户id或者金额不能为空");
        }
        boolean isSucc = accountServiceImpl.decrease(userId,money);
        if (!isSucc) {
            return Response.buildFailure("扣款失败");
        }
        return Response.buildSuccess(Boolean.TRUE, "扣款成功");

    }
}
