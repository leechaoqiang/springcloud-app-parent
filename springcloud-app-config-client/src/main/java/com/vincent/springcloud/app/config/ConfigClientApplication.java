package com.vincent.springcloud.app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置读取服务启动
 * @author vincent.li
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication implements CommandLineRunner {
    public static void main(String[] args) {
         SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ConfigClientApplication started");
    }
}
