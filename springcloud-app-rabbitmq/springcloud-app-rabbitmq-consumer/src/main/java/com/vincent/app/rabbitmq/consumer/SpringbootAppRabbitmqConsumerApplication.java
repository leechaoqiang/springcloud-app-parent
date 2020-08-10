package com.vincent.app.rabbitmq.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * rabbitmq消息消费服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication(scanBasePackages = {"com.vincent.app.rabbitmq.consumer"})
public class SpringbootAppRabbitmqConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootAppRabbitmqConsumerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【RABBITMQ-APP-CONSUMER】启动成功      O(∩_∩)O哈哈~");
    }

}
