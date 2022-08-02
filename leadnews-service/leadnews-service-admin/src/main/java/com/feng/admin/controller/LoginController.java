package com.feng.admin.controller;

import com.feng.admin.pojo.AdUser;
import com.feng.admin.service.AdUserService;
import com.feng.common.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author f
 * @date 2022/8/2 23:15
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdUserService adUserService;

    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestBody AdUser adUser) {
        Map<String, Object> map = adUserService.login(adUser);
        return Result.ok(map);
    }
}
