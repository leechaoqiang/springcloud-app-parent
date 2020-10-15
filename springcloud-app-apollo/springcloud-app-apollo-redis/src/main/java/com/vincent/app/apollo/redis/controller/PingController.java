package com.vincent.app.apollo.redis.controller;

import com.google.common.collect.ImmutableMap;
import com.vincent.app.apollo.redis.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 服务监控检查
 * </p>
 *
 * @author vincent.li
 * @since 2019-06-09
 */
@Slf4j
@RestController
public class PingController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;



    /**
     * @api {get} /ping ping一下应用服务
     *
     * @apiSampleRequest /ping
     */
    @GetMapping(value = "ping")
    @ResponseBody
    public  Map<String, Object> ping() {

        return  ImmutableMap.of("message","pong!",
                "applicationName", applicationName,
                "serverPort",serverPort);
    }

    @Resource
    private RedisService redisService;


    @GetMapping(value = "apollo/redis/set/{key}/{val}")
    @ResponseBody
    public  Map<String, Object> redisSet(@NotEmpty(message = "key cannot be empty") @PathVariable("key") String key,
                                         @NotNull(message = "val cannot be null") @PathVariable("val") String val) {
        log.warn("redisService.setStringToRedis before,key:"+key);
        redisService.setStringToRedis(key, val);
        log.info("redisService.setStringToRedis after,key:{},val:{}", key, val);
        return ImmutableMap.of("code", 200,
                "message","success");
    }

    @GetMapping(value = "apollo/redis/get/{key}")
    @ResponseBody
    public  Map<String, Object> redisGet(@NotEmpty(message = "key cannot be empty") @PathVariable("key") String key) {
        return ImmutableMap.of("code", 200,
                "message","success",
                "data", Optional.ofNullable(redisService.getStringFromRedis(key)).orElse("not found"));
    }



}
