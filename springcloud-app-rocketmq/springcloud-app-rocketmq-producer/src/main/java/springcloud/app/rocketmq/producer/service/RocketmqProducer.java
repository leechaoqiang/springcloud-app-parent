package springcloud.app.rocketmq.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * RocketMQ消息生产者服务
 *
 * @author vincent.li
 * @date 2020/08/18
 */
@Slf4j
@Component
public class RocketmqProducer {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${rocketmq.producer.topic}")
    private String testTopic;

    public void send(String topic, String message) {
        rocketMQTemplate.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                log.info("topic:" + topic + ",生产者推送成功。推送报文:[" + message + "]");
            }

            @Override
            public void onException(Throwable throwable) {
                log.info("topic:" + topic + ",生产者推送失败。推送报文:[" + message + "]");
            }
        });
    }

    public void send(String message) {
        send(testTopic, message);
    }
}
