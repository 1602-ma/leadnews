package com.feng.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.feng.admin.pojo.AdChannel;
import com.feng.common.pojo.PageInfo;
import com.feng.common.pojo.PageResultDto;
import com.feng.common.pojo.Result;
import com.feng.admin.service.AdChannelService;
import com.feng.common.pojo.StatusCode;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author f
 * @date 2022/7/31 15:51
 */
@RestController
@RequestMapping("/channel")
@Slf4j
@Api(value = "频道管理", tags = "channel", description = "频道管理")
public class AdChannelController {

    @Autowired
    private AdChannelService adChannelService;

    /**
     * 根据分页请求对象 分页查询频道列表
     *
     * @param pageRequestDto
     * @return
     */
    @PostMapping("/search")
    public Result<PageInfo<AdChannel>> searchByPage(@RequestBody PageResultDto<AdChannel> pageRequestDto) {
        PageInfo<AdChannel> result = adChannelService.searchByPage(pageRequestDto);
        return Result.ok(result);
    }

    /**
     * 新增频道
     * @param adChannel 频道信息
     * @return 成功与否
     */
    @PostMapping
    public Result insert(@RequestBody AdChannel adChannel) {
        boolean flag = adChannelService.save(adChannel);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 根据主键id获取频道信息
     * @param id id
     * @return 频道
     */
    @GetMapping("/{id}")
    public Result<AdChannel> findById(@PathVariable(name = "id") Integer id) {
        log.info("------------------------------------------根据id获取频道");
        AdChannel adChannel = adChannelService.getById(id);
        return Result.ok(adChannel);
    }

    /**
     * 频道修改
     * @param adChannel 要修改的频道信息
     * @return 成功与否
     */
    @PutMapping
    public Result updateById(@RequestBody AdChannel adChannel) {
        log.info("-------------------------------------修改频道");
        if (null == adChannel.getId()) {
            return Result.errorMessage("必须带有主键值", StatusCode.PARAM_ERROR.code(), null);
        }
        boolean flag = adChannelService.updateById(adChannel);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }

    /**
     * 根据id主键进行删除频道
     * @param id id
     * @return 成功与否
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable(name = "id") Integer id) {
        log.info("-----------------------------------------删除频道");
        boolean flag = adChannelService.removeById(id);
        if (!flag) {
            return Result.error();
        }
        return Result.ok();
    }
}
