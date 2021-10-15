package com.vincent.springcloud.app.bus.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 配置读取自动刷新服务启动
 * @author vincent.li
 */
@Slf4j
@SpringBootApplication(scanBasePackages = "com.vincent.springcloud.app.bus.config")
@EnableDiscoveryClient
public class ConfigBusClientApplication implements CommandLineRunner {
    public static void main(String[] args) {
         SpringApplication.run(ConfigBusClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ConfigBusClientApplication started...");
    }
}
