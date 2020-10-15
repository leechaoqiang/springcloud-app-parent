package com.vincent.app.kafka.consumer.service;

import com.vincent.app.kafka.consumer.constants.KafkaConsumerTopicConstant;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * kafka消息消费
 * @author vincent.li
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {KafkaConsumerTopicConstant.testTopicName})
    public void listen(ConsumerRecord<?, ?> record) {

        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {

            Object message = kafkaMessage.get();


            log.info(KafkaConsumerTopicConstant.testTopicName+"----------------- record==>{}", record);
            log.info(KafkaConsumerTopicConstant.testTopicName+"------------------ message==>{}" , message);
        }

    }
}
