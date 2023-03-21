/**
 * @ClassName: UserServiceDetailImpl
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 16:33
 * @Blog: 暂无
 */

package com.atguigu.security.demo.service.impl;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @ClassName: UserServiceDetailImpl
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 16:33
 * @Blog: 暂无
 */
@Service
public class UserServiceDetailImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userMapper.queryByName(username);
        return user;
    }
}
