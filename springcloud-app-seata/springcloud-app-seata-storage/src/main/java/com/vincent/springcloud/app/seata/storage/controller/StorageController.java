package com.vincent.springcloud.app.seata.storage.controller;

import com.vincent.springcloud.app.seata.storage.service.StorageService;
import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author vincent.li
 */
@RestController
@RequestMapping("storage")
public class StorageController {

    @Resource
    private StorageService storageServiceImpl;

    /**
     * 扣减库存
     * @param productId 产品id
     * @param count 数量
     * @return
     */
    @RequestMapping("/decrease")
    public Response<Boolean> decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count){
       boolean isDecSucceed = storageServiceImpl.decrease(productId,count);
       if (isDecSucceed) {
           return Response.buildSuccess(Boolean.TRUE, "扣减库存成功");
       }
       return Response.buildFailure("扣减库存失败");
    }
}
