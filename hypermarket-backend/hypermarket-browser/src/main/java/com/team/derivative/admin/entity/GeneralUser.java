package com.team.derivative.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author zhengxh
 */
@Data
@TableName(value = "admin_user")
public class GeneralUser {

    private String username;
    private String password;
    private String realName;
    private String email;
    private String telephone;
    private String mobilePhone;
    private String address;
    private String roleId;
    private String enabled;
}
