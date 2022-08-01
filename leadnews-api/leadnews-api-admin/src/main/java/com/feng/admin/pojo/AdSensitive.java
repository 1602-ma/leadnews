package com.feng.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 敏感词
 * @author f
 * @date 2022/8/1 21:20
 */
@Data
@TableName("ad_sensitive")
public class AdSensitive {

    /** 主键 */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /** 敏感词 */
    @TableField("sensitives")
    private String sensitives;

    /** 创建时间 */
    @TableField("created_time")
    private LocalDateTime createdTime;
}
