package com.feng.admin.controller;


import com.feng.admin.pojo.AdRole;
import com.feng.admin.service.AdRoleService;
import com.feng.core.controller.AbstractCoreController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 角色信息表 控制器</p>
* @author ljh
* @since 2022-08-02
*/
@Api(value="角色信息表",tags = "AdRoleController")
@RestController
@RequestMapping("/adRole")
public class AdRoleController extends AbstractCoreController<AdRole> {

    private AdRoleService adRoleService;

    //注入
    @Autowired
    public AdRoleController(AdRoleService adRoleService) {
        super(adRoleService);
        this.adRoleService=adRoleService;
    }

}

