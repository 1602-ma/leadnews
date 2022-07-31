package com.feng.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author f
 * @date 2022/7/31 11:54
 */
@Data
public class PageResultDto<T> implements Serializable {

    /** 当前页码 */
    private Long page = 1L;
    /** 每页显示行数 */
    private Long size = 10L;
    /** 请求实体对象 */
    private T body;
}
