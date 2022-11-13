package com.vincent.springcloud.app.nacos;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.TimeZone;

/**
 * nacos配置应用
 *
 * @author vincent.li
 * @date 2021/11/8 22:25
 */
@MapperScan("com.vincent.springcloud.app.nacos.dao")
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
public class SpringCloudNacosConfigApplication implements CommandLineRunner {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringCloudNacosConfigApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("(#^.^#)   【SpringCloud-app-nacos-config】启动成功      (#^.^#)");
    }
}
