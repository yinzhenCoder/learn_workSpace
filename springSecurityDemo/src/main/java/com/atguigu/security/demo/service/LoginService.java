/**
 * @ClassName: LoginService
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 15:07
 * @Blog: 暂无
 */

package com.atguigu.security.demo.service;


import com.atguigu.pojo.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 *
 * @ClassName: LoginService
 * @Description:
 * @author: 千山
 * @date: 2023-03-21 15:07
 * @Blog: 暂无
 */

@Service
public class LoginService {
    /**
     * 这个AuthenticationManager是来自下面一个代码块, 会有详细的解释.
     */
    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 通过security来校验
     */
    public String login(String username, String password) {
        // 用户验证
        Authentication authentication = null;
        try {
            // 该方法会去调用UserDetailsServiceImpl.loadUserByUsername() 交给他去校验账号密码.

                    authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            // 如果用户密码错误, 那么会抛出new BadCredentialsException()异常
            e.printStackTrace();
            // 返回一个空的token
            return "";
        }
        User loginUser = (User) authentication.getPrincipal();
        // 你有了user, 就可以生成token
        return createToken(loginUser);
    }

    // 之后我们再完善createToken即可, 目前只做伪逻辑.
    private String createToken(User loginUser) {
        return loginUser.toString();
    }
}
