package com.vincent.springcloud.app.feign.client;

import com.vincent.springcloud.seata.common.vo.resp.Response;
import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @Description
 * @since 2020/8/11
 */
@Component
public class SpringcloudAppApiHystrix implements SpringcloudAppApiClient {
    @Override
    public Response hello(String name) {
        return Response.buildSysError();
    }

    /**
     * 调用springcloud-app-api服务GET调用的sayHello方法
     *
     * @param name
     * @return
     */
    @Override
    public Response sayHello(String name) {
        return Response.buildSysError();
    }
}
