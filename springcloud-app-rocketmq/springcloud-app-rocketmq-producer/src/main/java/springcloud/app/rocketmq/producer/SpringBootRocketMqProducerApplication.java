package springcloud.app.rocketmq.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *  rocketmq消息生产服务SpringBoot 启动类
 * @author vincent.li
 */
@SpringBootApplication
public class SpringBootRocketMqProducerApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootRocketMqProducerApplication.class, args);
        System.out.println("O(∩_∩)O哈哈~    【TEST-ROCKETMQ-APP-PRODUCER】启动成功      O(∩_∩)O哈哈~");

    }

}
