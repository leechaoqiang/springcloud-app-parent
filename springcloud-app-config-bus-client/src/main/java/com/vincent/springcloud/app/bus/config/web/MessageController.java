package com.vincent.springcloud.app.bus.config.web;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageController {
    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String applicationName;

    @Value("${info.from}")
    String from;
    @Value("${info.profile}")
    String profile;

    @Value("${message}")
    private String message;

    @RequestMapping("/home")
    public String home() {

        return String.format("hello world from application [%s] ,port [%s]", applicationName, port) ;
    }

    @GetMapping("/config")
    public String getConfig() {
        return new JSONObject().fluentPut("message", message)
            .fluentPut("info.from", from)
            .fluentPut("info.profile", profile)
            .toJSONString();
    }
}
