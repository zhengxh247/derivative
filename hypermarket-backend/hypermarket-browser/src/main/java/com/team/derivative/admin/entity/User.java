package com.team.derivative.admin.entity;

import lombok.Data;

/**
 * @author zhengxh
 */
@Data
public class User {

    private String username;
    private String password;
    private String smsCode;
    private String email;
    private String mobilePhone;
}
