package com.vincent.springcloud.app.docker.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vincent.li
 * @Description docker-app-hello-world
 * @since 2019/6/29
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;


    @ResponseBody
    @GetMapping("/hello/{name}")
    public JSONObject hello(@PathVariable("name") String name){
        return new JSONObject()
                .fluentPut("hello", name)
                .fluentPut("application", applicationName)
                .fluentPut("port", serverPort);
    }

}
