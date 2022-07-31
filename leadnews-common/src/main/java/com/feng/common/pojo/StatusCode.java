package com.feng.common.pojo;

import lombok.ToString;

/**
 * 枚举类状态码
 * @author f
 * @date 2022/7/31 11:32
 */
public enum  StatusCode {
    //区别 http状态码
    SUCCESS(20000, "操作成功")
    , PARAM_ERROR(40000, "参数异常")
    , NOT_FOUND(40004, "资源不存在")
    , FAILURE(50000, "系统异常")
    , CUSTOM_FAILURE(50001, "自定义异常错误");

    private final Integer code;
    private final String message;

    StatusCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer code() {
        return code;
    }

    public String message() {
        return message;
    }

    @Override
    public String toString() {
        return String.valueOf(this.code);
    }
}
