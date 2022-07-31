package com.feng.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feng.admin.pojo.AdChannel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 频道管理mapper
 * @author f
 * @date 2022/7/31 15:45
 */
@Mapper
public interface AdChannelMapper extends BaseMapper<AdChannel> {

}
