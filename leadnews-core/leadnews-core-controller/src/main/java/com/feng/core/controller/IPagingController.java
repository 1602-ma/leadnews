package com.feng.core.controller;

import com.feng.common.pojo.PageInfo;
import com.feng.common.pojo.PageRequestDto;
import com.feng.common.pojo.Result;

/**
 * @author f
 * @date 2022/7/31 22:37
 */
public interface IPagingController<T> {

    /**
     * 根据查询条件 requestDto 分页查询
     * @param requestDto dto
     * @return result
     */
    Result<PageInfo<T>> findByPage(PageRequestDto<T> requestDto);
}
