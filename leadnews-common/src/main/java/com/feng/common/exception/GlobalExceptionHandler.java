package com.feng.common.exception;

import com.feng.common.pojo.Result;
import com.feng.common.pojo.StatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理类
 * @author f
 * @date 2022/7/31 22:12
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 用于当controller发送异常的时候被调用， 要捕获异常 代替 controller 去返回给前端
     * @param e e
     * @return exception
     */
    @ExceptionHandler(value = Exception.class)
    public Result handlerException(Exception e) {
        e.printStackTrace();
        return Result.error();
    }

    /**
     * LeadNewsException 业务上的异常，才进行处理
     * @param e e
     * @return exception
     */
    @ExceptionHandler(value = LeadNewsException.class)
    public Result handlerLeadNewsException(LeadNewsException e) {
        e.printStackTrace();
        return Result.errorMessage(e.getMessage(), StatusCode.CUSTOM_FAILURE.code(), null);
    }
}
