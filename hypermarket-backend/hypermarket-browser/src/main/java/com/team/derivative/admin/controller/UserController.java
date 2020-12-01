package com.team.derivative.admin.controller;

import com.team.derivative.admin.entity.User;
import com.team.derivative.admin.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/authentication")
@Slf4j
public class UserController {

    @Autowired
    private MyUserDetailsService service;

    @PostMapping("/user")
    public void login(@Validated @RequestBody User user) {
        System.out.println(user.getUsername());
        service.loadUserByUsername(user.getUsername());
    }
}
