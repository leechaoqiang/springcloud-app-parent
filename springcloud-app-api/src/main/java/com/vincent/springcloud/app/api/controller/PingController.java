package com.vincent.springcloud.app.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.vincent.springcloud.seata.common.constants.SystemConstants;
import com.vincent.springcloud.seata.common.vo.resp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author vincent.li
 * @Description 测试
 * @since 2020/6/29
 */
@Slf4j
@RestController
@RequestMapping(SystemConstants.APP_API)
public class PingController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;

    @ResponseBody
    @GetMapping("/ping")
    public Response<JSONObject> ping() {
        log.info("PingController.ping#serverPort:{}", serverPort);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("applicationName", applicationName);
        jsonObject.put("port", serverPort);
        jsonObject.put("message", "pong!");
        return Response.buildSuccess(jsonObject);
    }

    @ResponseBody
    @GetMapping("/hello")
    public Response hello(@RequestParam("name") String name) {
        log.info("PingController.hello#name:{}, serverPort:{}", name, serverPort);
        return Response.buildSuccess(new JSONObject().fluentPut("hello", name));
    }

    @ResponseBody
    @GetMapping(value = "hello/{name}")
    private Response<JSONObject> sayHello(@PathVariable("name") String name) {
        log.info("PingController.sayHello#name:{}, serverPort:{}", name, serverPort);
        return Response.buildSuccess(new JSONObject().fluentPut("sayHello", name));
    }

}
