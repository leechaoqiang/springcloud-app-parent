package com.licq.springcloud.app.config.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {
    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String applicationName;

    @Value("${info.from}")
    String from;

    @RequestMapping("/from")
    String from() {
        return this.from;
    }

    @RequestMapping("/home")
    public String home() {

        return String.format("hello world from application [%s] ,port [%s]", applicationName, port) ;
    }

    @Value("${message}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }
}
