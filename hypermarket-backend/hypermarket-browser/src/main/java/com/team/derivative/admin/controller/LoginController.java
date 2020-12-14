package com.team.derivative.admin.controller;

import com.team.derivative.admin.Vo.User;
import com.team.derivative.admin.service.MyUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/authentication")
@Api(tags = {"登录管理"}, description = "authentication")
public class LoginController {

    @Autowired
    private MyUserDetailsService service;

    @ApiOperation(value = "手机验证码登录")
    @PostMapping("/mobile")
    public Boolean login(@Validated @RequestBody User user) {
        return service.loginByMobile(user.getMobilePhone());
    }
}
