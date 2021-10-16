package com.vincent.springcloud.app.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 配置server服务启动
 * @author vincent.li
 */
@Slf4j
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ConfigServerApplication started...");
    }
}
