package com.vincent.springcloud.app.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka注册中心服务启动
 * @author vincent.li
 */
@Slf4j
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication implements CommandLineRunner {
    public static void main(String[] args) {
         SpringApplication.run(EurekaServerApplication.class, args);

     }

    @Override
    public void run(String... args) throws Exception {
        log.info("EurekaServerApplication started....");
    }
}
