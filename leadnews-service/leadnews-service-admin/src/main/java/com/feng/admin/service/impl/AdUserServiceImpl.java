package com.feng.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.feng.admin.mapper.AdUserMapper;
import com.feng.admin.pojo.AdUser;
import com.feng.admin.service.AdUserService;
import com.feng.common.exception.LeadNewsException;
import com.feng.common.utils.AppJwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 管理员用户信息表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2022-08-02
 */
@Service
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {

    @Autowired
    private AdUserMapper adUserMapper;


    /**
     * login
     * @param adUser user
     * @return map
     */
    @Override
    public Map<String, Object> login(AdUser adUser) {
        try {
            //判断是否为空，如果为空，提示错误
            if (StringUtils.isEmpty(adUser.getName()) || StringUtils.isEmpty(adUser.getPassword())) {
                throw new LeadNewsException("用户名或密码不能为空");
            }
            QueryWrapper<AdUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("name", adUser.getName());
            AdUser adUseFromDb = adUserMapper.selectOne(queryWrapper);
            if (null == adUseFromDb) {
                throw new LeadNewsException("用户名或密码错误");
            }
            String passwordFromWeb = adUser.getPassword() + adUseFromDb.getSalt();
            String passwordFromWebMd5 = DigestUtils.md5DigestAsHex(passwordFromWeb.getBytes());
            if (!passwordFromWebMd5.equals(adUseFromDb.getPassword())) {
                throw new LeadNewsException("用户名或密码错误");
            }
            //正确
            String token = AppJwtUtil.createToken(Long.valueOf(adUseFromDb.getId()));
            Map<String, Object> info = new HashMap<>();
            info.put("token", token);
            adUseFromDb.setSalt("");
            adUseFromDb.setPassword("");
            info.put("user", adUseFromDb);
            return info;
        } catch (LeadNewsException e) {
            log.error("登录失败啦");
        }
        return new HashMap<>();
    }
}
