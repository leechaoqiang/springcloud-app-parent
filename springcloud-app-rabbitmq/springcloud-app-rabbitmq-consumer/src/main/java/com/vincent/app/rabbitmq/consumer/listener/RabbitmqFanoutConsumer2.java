package com.vincent.app.rabbitmq.consumer.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @Description rabbitmq广播模式消费
 * @since 2019/8/9
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "${rabbitmq.consumer.2.queue.name}", durable = "true", autoDelete = "false"),
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.FANOUT))
)
public class RabbitmqFanoutConsumer2 {

    /**
     * 设置监听方法
     *
     * @param message
     * @RabbitHandler 声明监听方法是下面的 isDefault属性是默认false接受的完整对象，true接受body体
     */
    @RabbitHandler(isDefault = true)
    public void process(byte[] message) {
        System.out.println("Fanout-2 Receiver : " + new String(message));
    }

}
