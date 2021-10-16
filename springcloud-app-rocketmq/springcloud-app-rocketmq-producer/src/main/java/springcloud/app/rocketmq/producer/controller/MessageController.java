package springcloud.app.rocketmq.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.app.rocketmq.producer.service.RocketmqProducer;

import javax.annotation.Resource;

/**
 * 消息发送controller
 * @author vincent.li
 */
@RestController
@Slf4j
public class MessageController {

    @Resource
    RocketmqProducer rocketmqProducer;

    @GetMapping(value = "/send")
    public String send(String msg){
        try {
            rocketmqProducer.send(msg);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "failure";
        }
        return "success";
    }

}
