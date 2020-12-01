package com.team.derivative.admin.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author zhengxh
 */
@Data
public class User {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
    private String email;
    private String mobilePhone;
}
