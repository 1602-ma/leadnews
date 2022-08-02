package com.feng.admin.controller;


import com.feng.admin.pojo.AdUser;
import com.feng.admin.service.AdUserService;
import com.feng.core.controller.AbstractCoreController;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* <p>
* 管理员用户信息表 控制器</p>
* @author ljh
* @since 2022-08-02
*/
@Api(value="管理员用户信息表",tags = "AdUserController")
@RestController
@RequestMapping("/adUser")
public class AdUserController extends AbstractCoreController<AdUser> {

    private AdUserService adUserService;

    /**
     * 注入
     * @param adUserService service
     */
    @Autowired
    public AdUserController(AdUserService adUserService) {
        super(adUserService);
        this.adUserService=adUserService;
    }

}

