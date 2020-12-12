package com.team.derivative.admin.controller;

import com.team.derivative.admin.Vo.User;
import com.team.derivative.admin.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private MyUserDetailsService service;

    @PostMapping("/getAll")
    public void login(@Validated @RequestBody User user) {
        System.out.println(user.getUsername());
        service.loadUserByUsername(user.getUsername());
    }

    @PostMapping("/register")
    public Boolean register(@Validated @RequestBody User user) {
        return service.register(user);
    }
}
