package com.vincent.springcloud.app.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.TimeZone;

/**
 * @author vincent.li
 * @Description feign调用demo
 * @since 2019/7/11
 */
@SpringBootApplication(scanBasePackages = "com.vincent.springcloud.app.feign")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.vincent.springcloud.app.feign.client")
@EnableCircuitBreaker
public class SpringCloudAppFeignClientApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringCloudAppFeignClientApplication.class, args);
        System.out.println("(#^.^#)   【SpringCloudAppFeignClientApplication】启动成功      (#^.^#)");
    }

}
