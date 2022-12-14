package com.feng.admin.controller;


import com.feng.admin.pojo.AdUserRole;
import com.feng.admin.service.AdUserRoleService;
import com.feng.core.controller.AbstractCoreController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 管理员角色信息表 控制器</p>
* @author ljh
* @since 2022-08-02
*/
@Api(value="管理员角色信息表",tags = "AdUserRoleController")
@RestController
@RequestMapping("/adUserRole")
public class AdUserRoleController extends AbstractCoreController<AdUserRole> {

    private AdUserRoleService adUserRoleService;

    //注入
    @Autowired
    public AdUserRoleController(AdUserRoleService adUserRoleService) {
        super(adUserRoleService);
        this.adUserRoleService=adUserRoleService;
    }

}

