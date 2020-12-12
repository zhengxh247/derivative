package com.team.derivative.admin.controller;

import com.team.derivative.admin.Vo.User;
import com.team.derivative.admin.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/authentication")
public class LoginController {

    @Autowired
    private MyUserDetailsService service;

    @PostMapping("/mobile")
    public Boolean login(@Validated @RequestBody User user) {
        return service.loginByMobile(user.getMobilePhone());
    }
}
