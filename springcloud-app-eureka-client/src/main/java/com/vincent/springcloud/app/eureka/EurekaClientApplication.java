package com.vincent.springcloud.app.eureka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClientApplication  implements CommandLineRunner {
    public static void main(String[] args) {
         SpringApplication.run(EurekaClientApplication.class, args);
    }
    @Value("${server.port:8672}")
    String port;

    @Value("${spring.application.name}")
    String applicationName;

    @RequestMapping("/")
    public String home() {

      return String.format("hello world from application [%s] ,port [%s]", applicationName, port) ;
    }

    @RequestMapping("/hi")
    public String hi(final @RequestParam(value = "uname", defaultValue = "chaoqianglee") String uname) {

        return String.format("%s, hello from [%s] ,port [%s]", uname, applicationName, port) ;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("EurekaClientApplication started....");
    }
}
