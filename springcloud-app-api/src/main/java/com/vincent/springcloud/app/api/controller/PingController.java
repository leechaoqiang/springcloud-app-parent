package com.vincent.springcloud.app.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.vincent.springcloud.app.common.constants.SystemConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author vincent.li
 * @Description 测试
 * @since 2020/6/29
 */
@RestController
@RequestMapping(SystemConstants.APP_API)
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

    @ResponseBody
    @GetMapping("/hello")
    public JSONObject hello(@RequestParam("name") String name){
        return new JSONObject().fluentPut("hello", name);
    }

}
