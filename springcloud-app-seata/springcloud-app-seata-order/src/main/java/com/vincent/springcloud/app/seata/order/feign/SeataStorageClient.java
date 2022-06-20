package com.vincent.springcloud.app.seata.order.feign;

import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vincent.li
 */
@FeignClient(value = "${seata.storage.remote.service:springcloud-app-seata-storage}")
public interface SeataStorageClient {

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @GetMapping(value = "/storage/decrease")
    Response<Boolean> decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
