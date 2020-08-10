package com.vincent.app.kafka.producer.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vincent.app.kafka.producer.constants.KafkaTopicConstant;
import com.vincent.app.kafka.producer.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

/**
 * kafka消息生产
 */
@Component
@Slf4j
public class KafkaProducer {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    AtomicLong atomicLong = new AtomicLong(0L);

    public void send() {
        String msg = "中国崛起:"+atomicLong.incrementAndGet();
        send(msg);
    }


    public void send(final String msg) {
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(msg);
        message.setSendTime(new Date());
        log.info("+++++++++++++++++++++send  message = {}", gson.toJson(message));
        kafkaTemplate.send(KafkaTopicConstant.testTopicName, message.getId().toString() , gson.toJson(message));
    }
}
