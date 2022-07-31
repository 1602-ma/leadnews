package com.feng.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.admin.pojo.AdChannel;
import com.feng.common.pojo.PageInfo;
import com.feng.common.pojo.PageResultDto;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author f
 * @date 2022/7/31 15:49
 */
public interface AdChannelService extends IService<AdChannel> {

    /**
     * 分页查询频道
     * @param pageRequestDto dto
     * @return AdChannel
     */
    PageInfo<AdChannel> searchByPage(PageResultDto<AdChannel> pageRequestDto);
}
