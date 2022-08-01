package com.feng.core.controller;

import com.feng.common.pojo.Result;

import java.io.Serializable;

/**
 * @author f
 * @date 2022/7/31 22:35
 */
public interface IDeleteController<T> {

    /**
     * 根据ID 删除
     * @param id id
     * @return result
     */
    Result deleteById(Serializable id);
}
