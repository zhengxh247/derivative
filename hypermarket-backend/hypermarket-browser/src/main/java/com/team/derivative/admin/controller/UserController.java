package com.team.derivative.admin.controller;

import com.team.derivative.admin.Vo.User;
import com.team.derivative.admin.service.MyUserDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/user")
@Slf4j
@Api(tags = {"用户管理"}, description = "user")
public class UserController {

    @Autowired
    private MyUserDetailsService service;

    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public Boolean register(@Validated @RequestBody User user) {
        return service.register(user);
    }
}
