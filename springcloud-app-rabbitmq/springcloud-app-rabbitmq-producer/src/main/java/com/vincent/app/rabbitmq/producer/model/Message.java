package com.vincent.app.rabbitmq.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息体
 * @author vincent.li
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Message implements Serializable {

    private Long id;
    /**
     * 消息
    * */
    private String msg;
    /**
     * 时间戳
     * */
    private Date sendTime;

}