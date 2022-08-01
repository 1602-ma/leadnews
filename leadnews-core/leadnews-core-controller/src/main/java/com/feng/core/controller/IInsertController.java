package com.feng.core.controller;

import com.feng.common.pojo.Result;

/**
 * @author f
 * @date 2022/7/31 22:36
 */
public interface IInsertController<T> {

    /**
     * 添加记录
     * @param record record
     * @return result
     */
    Result insert(T record);
}
