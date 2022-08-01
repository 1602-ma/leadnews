package com.feng.common.exception;

import com.feng.common.pojo.StatusCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自定义异常
 * @author f
 * @date 2022/7/31 22:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeadNewsException extends Exception{

    /** 错误的状态码 */
    private Integer code;
    /** 错误信息 */
    private String message;

    public LeadNewsException(String message) {
        this.code = StatusCode.CUSTOM_FAILURE.code();
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
