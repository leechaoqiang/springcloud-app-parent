package com.vincent.springcloud.app.nacos.controller;

import com.alibaba.fastjson.JSONObject;
import com.vincent.springcloud.common.model.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author vincent.li
 * @date 2022/11/8 22:45
 */
@Slf4j
@RestController
@RequestMapping("hello")
public class HelloController {
    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;
    @Resource
    private StringRedisTemplate stringRedisTemplate;
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
    @GetMapping("/set/{key}/{cacheVal}")
    public Response setCache(@PathVariable("key") String key, @PathVariable("cacheVal") String cacheVal) {
        log.info("PingController.setCache#key:{} ==> cacheVal: {}", key, cacheVal);
        stringRedisTemplate.opsForValue().set(key, cacheVal, 2000L);
        return Response.buildSuccess();
    }

    @ResponseBody
    @GetMapping("/get/{key}")
    public Response getCache(@PathVariable("key") String key) {
        log.info("PingController.getCache#key:{} ", key);
        Object cacheVal = stringRedisTemplate.opsForValue().get(key);
        return Response.buildSuccess(cacheVal);
    }

}
