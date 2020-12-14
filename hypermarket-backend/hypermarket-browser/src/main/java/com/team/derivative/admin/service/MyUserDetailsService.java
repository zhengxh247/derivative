/**
 *
 */
package com.team.derivative.admin.service;

import com.team.derivative.admin.dao.UserMapper;
import com.team.derivative.admin.entity.GeneralUserEntity;
import com.team.derivative.admin.Vo.User;
import com.team.derivative.admin.exceptioin.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

/**
 * @author zhengxh
 *
 */
@Component
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("表单登录用户名:" + username);
        return buildUser(username);
    }

    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        logger.info("设计登录用户Id:" + userId);
        return buildUser(userId);
    }

    private SocialUserDetails buildUser(String username) {
        // 根据用户名查找用户信息
        //根据查找到的用户信息判断用户是否被冻结
        System.out.println(username);
        GeneralUserEntity user = userMapper.getUserByUsername(username);
        String password = passwordEncoder.encode("2");
        logger.info("数据库密码是:" + password);
        return new SocialUser(username, user.getPassword(),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }

    public Boolean loginByMobile(String mobile) {

        try {
            userMapper.getUserByMobile(mobile);
        } catch (Exception e) {
            throw ServiceException.notExistMobile(mobile);
        }
        return true;
    }

    public Boolean register(User user) {

        if (userMapper.getUserByMobile(user.getMobilePhone()) != null){
            throw ServiceException.IsExistMobile(user.getMobilePhone());
        }else {
            String password = passwordEncoder.encode(user.getPassword());
            GeneralUserEntity generalUser = new GeneralUserEntity();
            generalUser.setMobilePhone(user.getMobilePhone());
            generalUser.setPassword(password);
            generalUser.setUsername(user.getUsername());
            generalUser.setEmail(user.getEmail());
            userMapper.insert(generalUser);
        }
        return true;
    }

}
