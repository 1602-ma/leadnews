package com.feng.common.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author f
 * @date 2022/7/31 11:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "分页请求对象")
public class PageResultDto<T> implements Serializable {

    /** 当前页码 */
    @ApiModelProperty(notes = "当前页码")
    private Long page = 1L;
    /** 每页显示行数 */
    @ApiModelProperty(notes = "每页显示行数")
    private Long size = 10L;
    /** 请求实体对象 */
    @ApiModelProperty(notes = "请求实体对象")
    private T body;
}
