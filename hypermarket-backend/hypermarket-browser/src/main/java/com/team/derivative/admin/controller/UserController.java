package com.team.derivative.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhengxh
 */
@RestController
@RequestMapping("/authentication")
@Slf4j
public class UserController {

    @Autowired
    private UserDetailsService service;

    @GetMapping("/login")
    public void login(@Validated @PathVariable String username) {
        service.loadUserByUsername(username);
    }
}
