package com.licq.springcloud.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RefreshScope
public class ConfigClientApplication {
    public static void main(String[] args) {
         SpringApplication.run(ConfigClientApplication.class, args);
    }
    @Value("${server.port}")
    String port;

    @Value("${spring.application.name}")
    String applicationName;

    @RequestMapping("/home")
    public String home() {

      return String.format("hello world from application [%s] ,port [%s]", applicationName, port) ;
    }

    @Value("${message:Hello default}")
    private String message;

    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }



}
