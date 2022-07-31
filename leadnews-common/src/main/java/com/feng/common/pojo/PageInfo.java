package com.feng.common.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author f
 * @date 2022/7/31 11:56
 */
@Data
public class PageInfo<T> implements Serializable {
    /** 当前页码 */
    private Long page;
    /** 每页显示行数 */
    private Long size;
    /** 总记录数 */
    private Long total;
    /** 总页数 */
    private Long totalPages;
    /** 当前页记录 */
    private List<T> list;
}
