package com.feng.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.feng.admin.pojo.AdUser;

import java.util.Map;

/**
 * @author f
 * @date 2022/8/2 22:43
 */
public interface AdUserService extends IService<AdUser> {

    /**
     * 登录
     * @param adUser user
     * @return map
     */
    Map<String, Object> login(AdUser adUser);
}
