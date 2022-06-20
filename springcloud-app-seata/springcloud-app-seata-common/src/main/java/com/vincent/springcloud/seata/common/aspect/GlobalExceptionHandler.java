package com.vincent.springcloud.seata.common.aspect;

import com.vincent.springcloud.seata.common.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公共异常处理
 *
 * @author vincent.li
 * @date 2021/6/20 17:01
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response runtimeException(RuntimeException e) {
        return Response.buildFailure(e.getMessage());
    }
}
