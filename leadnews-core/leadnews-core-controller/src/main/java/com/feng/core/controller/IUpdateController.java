package com.feng.core.controller;

import com.feng.common.pojo.Result;

/**
 * @author f
 * @date 2022/7/31 22:41
 */
public interface IUpdateController<T> {

    /**
     * 根据对象进行更新 根据ID
     * @param record record
     * @return result
     */
    Result updateByPrimaryKey(T record);
}
