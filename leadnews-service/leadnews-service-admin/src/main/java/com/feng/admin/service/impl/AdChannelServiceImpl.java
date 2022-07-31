package com.feng.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.admin.pojo.AdChannel;
import com.feng.admin.mapper.AdChannelMapper;
import com.feng.admin.service.AdChannelService;
import com.feng.common.pojo.PageInfo;
import com.feng.common.pojo.PageResultDto;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author f
 * @date 2022/7/31 15:49
 */
@Service
public class AdChannelServiceImpl extends ServiceImpl<AdChannelMapper, AdChannel> implements AdChannelService {

    @Override
    public PageInfo<AdChannel> searchByPage(PageResultDto<AdChannel> pageRequestDto) {
        Long page = pageRequestDto.getPage();
        Long size = pageRequestDto.getSize();
        AdChannel body = pageRequestDto.getBody();
        QueryWrapper<AdChannel> queryWrapper = new QueryWrapper<>();

        if (null != body) {
            if (!StringUtils.isEmpty(body.getName())) {
                queryWrapper.like("name", body.getName());
            }
            if (!StringUtils.isEmpty(body.getStatus())) {
                queryWrapper.eq("status", body.getStatus());
            }
        }

        Page<AdChannel> page1 = new Page<>(page, size);
        IPage<AdChannel> page2 = page(page1, queryWrapper);

        return new PageInfo<>(page2.getCurrent(),
                page2.getSize(),
                page2.getTotal(),
                page2.getPages(),
                page2.getRecords());
    }
}
