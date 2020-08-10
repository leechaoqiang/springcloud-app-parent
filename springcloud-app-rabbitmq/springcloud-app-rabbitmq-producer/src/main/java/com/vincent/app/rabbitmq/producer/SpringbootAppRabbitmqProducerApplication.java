package com.vincent.app.rabbitmq.producer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * rabbitmq消息生产服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication(scanBasePackages = {"com.vincent.app.rabbitmq.producer"})
public class SpringbootAppRabbitmqProducerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootAppRabbitmqProducerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【RABBITMQ-APP-PRODUCER】启动成功      O(∩_∩)O哈哈~");
    }

}
