package com.vincent.app.rabbitmq.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
public class HealthCheckController {

    @Value("${server.port}")
    private String serverPort;
    @Value("${spring.application.name}")
    private String applicationName;



    /**
     * @api {get} /ping ping一下应用服务
     * @apiDescription  测试应用是否正常运行
     * @apiVersion 1.0.0
     * @apiGroup Test
     *
     *
     * @apiSuccess {String} message  消息
     * @apiSuccess {String} profilesActive  环境
     * @apiSuccess {String} applicationName  应用名
     * @apiSuccess {String} serverPort  端口
     * @apiSuccessExample Success-Response:
     * {
     *     "message":"pong!",
     *     "profilesActive":"dev",
     *     "applicationName": "membercenter-api",
     *     "serverPort": 8073
     * }
     *
     *
     * @apiSampleRequest /ping
     */
    @GetMapping(value = "ping")
    @ResponseBody
    public  Map<String, Object> healthCheck() {
        Map<String, Object> map = new HashMap<>();
        map.put("message","pong!");
        map.put("applicationName", applicationName);
        map.put("serverPort",serverPort);
        return map;
    }



}
