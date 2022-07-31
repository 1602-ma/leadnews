package com.feng.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author f
 * @date 2022/7/31 15:10
 */
@Data
@TableName("ad_channel")
public class AdChannel {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 频道名称 */
    @TableField("name")
    private String name;

    /** 频道描述 */
    @TableField("description")
    private String description;

    /** 是否默认频道 */
    @TableField("is_default")
    private Boolean idDefault;

    /** 状态 */
    @TableField("status")
    private Boolean status;

    /** 默认排序 */
    @TableField("ord")
    private Integer ord;

    /** 创建时间 */
    @TableField("created_time")
    private Date createdTime;
}
