package com.team.derivative.admin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.team.derivative.admin.entity.GeneralUserEntity;
import org.apache.ibatis.annotations.Select;


/**
 * @author zhengxh
 */

public interface UserMapper extends BaseMapper<GeneralUserEntity>{

    /**
     * 根据账号获取用户信息
     * @param username
     * @return GeneralUser
     */
    @Select("select * from admin_user where (username = #{username} or mobile_phone  = #{username})")
    GeneralUserEntity getUserByUsername(String username);

    /**
     * 根据手机号码获取用户信息
     * @param mobile
     * @return GeneralUser
     */
    @Select("select * from admin_user where mobile_phone = #{mobile}")
    GeneralUserEntity getUserByMobile(String mobile);

    /**
     * 根据手机号码插入用户信息
     * @param User
     * @return GeneralUser
     */
    @Override
    int insert(GeneralUserEntity entity);
}
