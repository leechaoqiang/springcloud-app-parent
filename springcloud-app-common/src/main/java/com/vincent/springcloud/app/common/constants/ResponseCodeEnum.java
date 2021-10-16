package com.vincent.springcloud.app.common.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 响应码枚举
 *
 * @author vincent.li
 * @date 2019/05/12
 */
@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {

    SYS_ERROR("SYS_ERROR", "系统繁忙,请稍后再试"),
    SUCCESS("200", "请求成功"),
    FAIL("500", "请求失败");

    private final String code;
    private final String msg;
}
