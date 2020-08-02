package com.licq.app.kafka.producer;

import com.licq.app.kafka.producer.service.KafkaProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * kafka消息生产服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication(scanBasePackages = {"com.licq.app.kafka.producer"})
public class SpringBootKafkaProducerApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringBootKafkaProducerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【TEST-KAFKA-APP-PRODUCER】启动成功      O(∩_∩)O哈哈~");
        KafkaProducer sender = context.getBean(KafkaProducer.class);

        for (int i = 0; i < 1000; i++) {
            sender.send();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
