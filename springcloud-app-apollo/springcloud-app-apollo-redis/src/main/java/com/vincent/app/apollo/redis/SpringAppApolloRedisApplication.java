package com.vincent.app.apollo.redis;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Apllo-redis配置动态加载demo-SpringBoot 启动类
 * @author vincent.li
 * @since 2020-08-01
 */
@EnableApolloConfig
@SpringBootApplication(scanBasePackages = {"com.vincent.app.apollo.redis"})
public class SpringAppApolloRedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringAppApolloRedisApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【SPRINGCLOUD-APP-APOLLO-REDIS】启动成功      O(∩_∩)O哈哈~");

    }

}
