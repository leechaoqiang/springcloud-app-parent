package com.vincent.springcloud.app.feign.controller;

import com.alibaba.fastjson.JSONObject;
import com.vincent.springcloud.app.common.constants.SystemConstants;
import com.vincent.springcloud.app.feign.client.SpringcloudAppApiClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author vincent.li
 * @Description 测试
 * @since 2019/6/29
 */
@RestController
@RequestMapping(SystemConstants.APP_FEIGN)
public class PingController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;

    @ResponseBody
    @GetMapping("/ping")
    public JSONObject ping(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("applicationName", applicationName);
        jsonObject.put("port", serverPort);
        jsonObject.put("message", "pong!");
        return jsonObject;
    }

    @Resource
    private SpringcloudAppApiClient springcloudAppApiClient;

    @ResponseBody
    @GetMapping("/hi/{name}")
    public String hello(@PathVariable("name") String name){
        return springcloudAppApiClient.hello(name);
    }

}
