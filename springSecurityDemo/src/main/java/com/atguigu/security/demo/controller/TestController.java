/**
 * @ClassName: TestController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 15:13
 * @Blog: 暂无
 */

package com.atguigu.security.demo.controller;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @ClassName: TestController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 15:13
 * @Blog: 暂无
 */
@RestController
@RequestMapping("/user")
public class TestController {

    @Autowired
    private UserMapper parameterMapper;


    @GetMapping("/{username}")
    public String getUser(@PathVariable String username){
        User userByUsername = parameterMapper.queryByName(username);
        String password = userByUsername.getPassword();
        return password;
    }


}
