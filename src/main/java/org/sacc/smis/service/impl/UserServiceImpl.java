package org.sacc.smis.service.impl;

import org.sacc.smis.entity.User;
import org.sacc.smis.mapper.UserMapper;
import org.sacc.smis.model.UserInfo;
import org.sacc.smis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by 林夕
 * Date 2021/1/19 22:02
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByStudentId(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        return new UserInfo(user);
    }
}
