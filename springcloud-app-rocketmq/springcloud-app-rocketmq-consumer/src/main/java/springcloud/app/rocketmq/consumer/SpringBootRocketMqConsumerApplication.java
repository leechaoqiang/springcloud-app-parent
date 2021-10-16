package springcloud.app.rocketmq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  rocketmq消息消费服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication
public class SpringBootRocketMqConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRocketMqConsumerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【TEST-ROCKETMQ-APP-CONSUMER】启动成功      O(∩_∩)O哈哈~");

    }

}
