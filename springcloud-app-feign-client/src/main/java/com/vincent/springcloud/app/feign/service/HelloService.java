package com.vincent.springcloud.app.feign.service;

import com.vincent.springcloud.seata.common.vo.resp.Response;
import com.vincent.springcloud.app.feign.client.SpringcloudAppApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * hello测试服务
 *
 * @author vincent.li
 * @date 2020/05/12
 */
@Slf4j
@Component
public class HelloService {

    @Resource
    private SpringcloudAppApiClient apiClient;

    public Response hi(String name) {
        log.info("HelloService.hi#{}", name);
        return apiClient.hello(name);
    }

    public Response sayHi(String name) {
        log.info("HelloService.sayHi#{}", name);
        return apiClient.sayHello(name);
    }
}
