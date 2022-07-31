package com.feng.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author f
 * @date 2022/7/31 11:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "分页对象")
public class PageInfo<T> implements Serializable {
    /** 当前页码 */
    @ApiModelProperty(notes = "当前页码")
    private Long page;
    /** 每页显示行数 */
    @ApiModelProperty(notes = "每页显示的行")
    private Long size;
    /** 总记录数 */
    @ApiModelProperty(notes = "总记录数")
    private Long total;
    /** 总页数 */
    @ApiModelProperty(notes = "总页数")
    private Long totalPages;
    /** 当前页记录 */
    @ApiModelProperty(notes = "当前页记录")
    private List<T> list;
}
