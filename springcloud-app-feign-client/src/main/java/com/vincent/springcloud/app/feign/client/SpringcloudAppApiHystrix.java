package com.vincent.springcloud.app.feign.client;

import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @Description
 * @since 2020/8/11
 */
@Component
public class SpringcloudAppApiHystrix implements SpringcloudAppApiClient {
    @Override
    public String hello(String name) {
        return "请求超时了,请稍后再试";
    }
}
