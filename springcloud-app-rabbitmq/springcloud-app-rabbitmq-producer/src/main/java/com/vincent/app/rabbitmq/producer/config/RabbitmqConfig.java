package com.vincent.app.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author vincent.li
 * @Description Rabbitmq配置
 * @since 2020/8/10
 */
@Component
public class RabbitmqConfig {

    @Value("${rabbitmq.config.exchange}")
    private String fanoutExchangeName;
    @Value("${rabbitmq.producer.queue.name}")
    private String producerQueueName;

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(fanoutExchangeName, true, false);
    }

    @Bean(name = "basicQueue")
    public Queue basicQueue() {
        return new Queue(producerQueueName, true);
    }

    @Bean
    public Binding basicBinding() {
        return BindingBuilder.bind(basicQueue()).to(fanoutExchange());

    }
}
