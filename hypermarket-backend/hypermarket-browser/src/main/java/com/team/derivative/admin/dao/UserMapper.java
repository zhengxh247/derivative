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
    @Select("select * from admin_user where (username = #{username} or mobile_phone  = #{username})")
    GeneralUser getUserByUsername(String username);

    /**
     * 根据手机号码获取用户信息
     * @param mobile
     * @return GeneralUser
     */
    @Select("select * from admin_user where mobile_phone = #{mobile}")
    GeneralUser getUserByMobile(String mobile);

    /**
     * 根据手机号码插入用户信息
     * @param User
     * @return GeneralUser
     */
    @Override
    int insert(GeneralUser entity);
}
