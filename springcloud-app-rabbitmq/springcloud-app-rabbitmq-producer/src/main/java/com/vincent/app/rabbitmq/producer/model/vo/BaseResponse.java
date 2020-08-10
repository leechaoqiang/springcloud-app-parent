package com.vincent.app.rabbitmq.producer.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author vincent.li
 * @Description 基本返回类
 * @since 2020/8/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    private String code = "200";
    private String msg = "success";
    private T data;

    public static BaseResponse success(){
        return success(null);
    }

    public static <T> BaseResponse success(T data){
        BaseResponse response = new BaseResponse();
        response.setData(data);
        return response;
    }

    public static BaseResponse fail(String msg){
         return fail("500", msg);
    }

    public static <T> BaseResponse fail(String code,String msg){
        return new BaseResponse(code, msg, null);
    }

}
