package com.vincent.app.rabbitmq.producer.controller;

import com.vincent.app.rabbitmq.producer.model.Message;
import com.vincent.app.rabbitmq.producer.model.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author vincent.li
 * @Description Rabbitmq消息生产控制器
 * @since 2020/8/9
 */
@Slf4j
@RestController
@RequestMapping(value = "rabbitmq")
public class RabbitmqProduceController {


    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.config.exchange}")
    private String fanoutExchangeName;

    /**
     * 发送消息
     * @param msg
     * @return
     */
    @GetMapping("/message/send")
    public BaseResponse sendMessage(@RequestParam String msg){
        if (StringUtils.isEmpty(msg)) {
            return BaseResponse.fail("请输入有效参数");
        }
        try {
            log.info("待发送的消息： {} ", msg);

            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange(fanoutExchangeName);

            Message message = Message.builder()
                    .id(System.currentTimeMillis())
                    .msg(msg)
                    .sendTime(new Date())
                    .build();
            rabbitTemplate.convertAndSend(message);
        }catch (Exception e){
            log.error("发送消息发生异常： ", e.fillInStackTrace());
            return BaseResponse.fail("发送消息发生异常");
        }
        return BaseResponse.success();
    }



}