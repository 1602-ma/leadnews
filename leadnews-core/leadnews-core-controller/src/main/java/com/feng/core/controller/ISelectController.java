package com.feng.core.controller;

import com.feng.common.pojo.Result;

import java.io.Serializable;
import java.util.List;

/**
 * @author f
 * @date 2022/7/31 22:39
 */
public interface ISelectController<T> {

    /**
     * 根据ID 获取信息
     * @param id id
     * @return result
     */
    public Result<T> findById(Serializable id);

    /**
     * 根据ID 获取信息列表
     * @return result
     */
    public Result<List<T>> findAll();

    /**
     * 根据信息获取列表
     * @param record record
     * @return result
     */
    public Result<List<T>> findByRecord(T record);
}
