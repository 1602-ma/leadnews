package com.feng.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.admin.pojo.AdChannel;
import com.feng.common.pojo.PageInfo;
import com.feng.common.pojo.PageRequestDto;

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
    PageInfo<AdChannel> searchByPage(PageRequestDto<AdChannel> pageRequestDto);
}
