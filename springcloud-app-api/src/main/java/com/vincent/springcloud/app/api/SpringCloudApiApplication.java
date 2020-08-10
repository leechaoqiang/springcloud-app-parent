package com.vincent.springcloud.app.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * @author vincent.li
 * @Description api提供服务
 * @since 2020/6/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudApiApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringCloudApiApplication.class, args);
        System.out.println("(#^.^#)   【SpringCloud-app-api】启动成功      (#^.^#)");
    }
}
