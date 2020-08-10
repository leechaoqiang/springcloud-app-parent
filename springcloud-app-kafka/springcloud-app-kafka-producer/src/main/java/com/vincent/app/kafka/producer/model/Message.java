package com.vincent.app.kafka.producer.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 消息体
 * @author vincent.li
 */
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