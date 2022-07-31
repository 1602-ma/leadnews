package com.feng.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author f
 * @date 2022/7/31 11:23
 */
@ApiModel(description = "通用返回响应结果对象", value = "result")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {

    private static final String STATUS_SUCCESS = "2000";

    @ApiModelProperty(notes = "响应结果的错误信息", required = true)
    private String message;

    @ApiModelProperty(notes = "响应结果的错误信息状态码，2000x表示成功，4000x表示错误，5000x表示服务端异常", required = true)
    private Integer code;

    @ApiModelProperty(notes = "响应结果逻辑数据", required = true)
    private T data;

    /** 成功 并不返回数据 */
    public static <T> Result<T> ok() {
        return new Result<>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), null);
    }

    /** 成功 并返回数据 */
    public static <T> Result<T> ok(T data) {
        return new Result<>(StatusCode.SUCCESS.message(), StatusCode.SUCCESS.code(), data);
    }

    /** 系统错误 不返回数据 */
    public static <T> Result<T> error() {
        return new Result<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), null);
    }

    /** 系统错误 并返回逻辑数据 */
    public static <T> Result<T> error(T data) {
        return new Result<T>(StatusCode.FAILURE.message(), StatusCode.FAILURE.code(), data);
    }

    /** 错误并返回指定错误信息和状态码以及逻辑数据 */
    public static <T> Result<T> error(StatusCode statusCode, T data) {
        return new Result<T>(statusCode.message(), statusCode.code(), data);
    }

    /**  错误并返回指定错误信息和状态码 不返回数据 */
    public static <T> Result<T> error(StatusCode statusCode) {
        return new Result<T>(statusCode.message(), statusCode.code(), null);
    }

    /** 自定义错误和状态返回 */
    public static <T> Result<T> errorMessage(String message, Integer code, T data) {
        return new Result<T>(message, code, data);
    }

    /** 自定义错误信息 状态码固定 */
    public static <T> Result<T> errorMessage(String message) {
        return new Result<T>(message, StatusCode.CUSTOM_FAILURE.code(), null);
    }

    /**
     * 是否操作成功  2000X都是成功
     * @return true or false
     */
    public Boolean isSuccess() {
        if (code.toString().startsWith(STATUS_SUCCESS)) {
            return true;
        }
        return false;
    }
}
