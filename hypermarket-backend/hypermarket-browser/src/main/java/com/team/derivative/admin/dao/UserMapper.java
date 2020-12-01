package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GeneralUser;
import org.apache.ibatis.annotations.Select;


/**
 * @author zhengxh
 */

public interface UserMapper extends BaseMapper<GeneralUser>{

    /**
     * 根据账号获取用户信息
     * @param username
     * @return GeneralUser
     */
    @Select("select * from admin_user where username = #{username}")
    GeneralUser getUserByUsername(String username);
}
