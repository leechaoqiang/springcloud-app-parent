package com.vincent.springcloud.app.feign.client;

import com.vincent.springcloud.common.model.vo.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author vincent.li
 * @Description springcloud-app-api feign调用
 * @since 2020/8/11
 */
@FeignClient(value = "springcloud-app-api", fallback = SpringcloudAppApiHystrix.class)
public interface SpringcloudAppApiClient {

    /**
     * 调用springcloud-app-api服务GET调用的hello方法
     * @param name
     * @return
     */
    @GetMapping(value = "/app/api/hello")
    Response hello(@RequestParam("name") String name);

    /**
     * 调用springcloud-app-api服务GET调用的sayHello方法
     * @param name
     * @return
     */
    @GetMapping(value = "/app/api/hello/{name}")
    Response sayHello(@PathVariable("name") String name);
}
