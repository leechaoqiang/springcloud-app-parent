package com.vincent.app.kafka.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * kafka消息消费服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication(scanBasePackages = {"com.vincent.app.kafka.consumer"})
public class SpringBootKafkaConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootKafkaConsumerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【TEST-KAFKA-APP-CONSUMER】启动成功      O(∩_∩)O哈哈~");

    }

}
