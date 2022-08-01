package com.feng.admin.controller;

import com.feng.admin.pojo.AdSensitive;
import com.feng.admin.service.AdSensitiveService;
import com.feng.core.controller.AbstractCoreController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 敏感词信息表 控制器
 * @author f
 * @date 2022/8/1 21:26
 */
@Api(value = "敏感词信息表", tags = "AdSensitiveController")
@RestController
@RequestMapping("/adSensitive")
public class AdSensitiveController extends AbstractCoreController<AdSensitive> {

    private AdSensitiveService adSensitiveService;

    @Autowired
    public AdSensitiveController(AdSensitiveService adSensitiveService) {
        super(adSensitiveService);
        this.adSensitiveService = adSensitiveService;
    }
}
