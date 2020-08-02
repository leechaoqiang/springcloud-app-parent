package com.licq.app.kafka.producer.controller;

import com.licq.app.kafka.producer.service.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息发送controller
 * @author vincent.li
 */
@RestController
@Slf4j
public class MessageController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping(value = "/send")
    public String send(String msg){
        try {
            kafkaProducer.send(msg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "failure";
        }
        return "success";
    }

}
