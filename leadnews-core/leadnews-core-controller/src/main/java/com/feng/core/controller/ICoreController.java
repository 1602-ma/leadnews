package com.feng.core.controller;

/**
 * @author f
 * @date 2022/7/31 22:29
 */
public interface ICoreController<T> extends ISelectController<T>,
        IInsertController<T>,
        IPagingController<T>,
        IDeleteController<T>,
        IUpdateController<T> {
}
