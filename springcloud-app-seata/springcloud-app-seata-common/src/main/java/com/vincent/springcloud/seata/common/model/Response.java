package com.vincent.springcloud.seata.common.model;

import com.vincent.springcloud.seata.common.enums.ResponseCodeEnum;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * 返回基类
 *
 * @author vincent.li
 * @date 2019/05/12
 */
@Data
public class Response<T> {
    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 响应码
     */
    private String code;
    /**
     * 响应描述
     */
    private String message;
    /**
     * 响应业务数据
     */
    private T data;

    public Response() {
    }

    @Override
    public String toString() {
        return "Response [success=" + this.success + ", code=" + this.code + ", message=" + this.message + "]";
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setSuccess();
        return response;
    }

    public static <T> Response<T> buildSuccess(T data) {
        Response response = buildSuccess();
        response.setData(data);
        return response;
    }

    public static Response buildSuccess(String msg) {
        Response response = buildSuccess();
        response.setMessage(msg);
        return response;
    }

    public static <T> Response<T> buildSuccess(T data, String msg) {
        Response response = buildSuccess();
        response.setData(data);
        response.setMessage(msg);
        return response;
    }

    public static Response buildFailure(String code, String message) {
        Response response = new Response();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(message);
        return response;
    }

    public static Response buildFailure(ResponseCodeEnum responseCodeEnum) {
        return buildFailure(responseCodeEnum.getCode(), responseCodeEnum.getMsg());
    }

    public static Response buildFailure(String msg) {
        return buildFailure(ResponseCodeEnum.FAIL.getCode(), StringUtils.isEmpty(msg) ? ResponseCodeEnum.FAIL.getMsg() : msg);
    }

    public static Response buildFailure() {
        return buildFailure(ResponseCodeEnum.FAIL);
    }

    public static Response buildSysError() {
        return buildFailure(ResponseCodeEnum.SYS_ERROR);
    }

    public boolean isSuccess() {
        return ResponseCodeEnum.SUCCESS.getCode().equals(this.code);
    }

    protected void setSuccess() {
        this.code = ResponseCodeEnum.SUCCESS.getCode();
    }

}
