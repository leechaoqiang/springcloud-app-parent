package springcloud.app.rocketmq.consumer.service;

/**
 * RocketMq消费
 *
 * @author vincent.li
 * @date 2021/8/31
 */

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RocketMQMessageListener(
    topic = "${rocketmq.consumer.topic}",
    consumerGroup = "${rocketmq.consumer.group}",
    messageModel = MessageModel.CLUSTERING,
    nameServer = "${rocketmq.name_server}"
)
public class RocketMqConsumer implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {

    @Override
    public void onMessage(String message) {
        log.info("队列" + "test_topic" + "获取到的数据为" + message);
    }

    @Override
    public void prepareStart(DefaultMQPushConsumer defaultMQPushConsumer) {

        defaultMQPushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                try {
                    for (MessageExt msg : list) {
                        String msgbody = new String(msg.getBody(), "utf-8");
                        onMessage(msgbody);
                        log.info("【消费消息】 次数：" + msg.getReconsumeTimes() + ", ext ：" + msgbody);
                    }
                } catch (Exception e) {
                    log.error("rocketMQ消费异常:", e);
                    if (list.get(0).getReconsumeTimes() == 4) {
                        //记录日志
                        // 成功
                        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                    } else {
                        // 重试
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                // 成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

    }

}
