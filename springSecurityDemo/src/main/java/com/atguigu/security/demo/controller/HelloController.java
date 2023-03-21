/**
 * @ClassName: HelloController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:14
 * @Blog: 暂无
 */

package com.atguigu.security.demo.controller;

import com.atguigu.security.demo.pojo.LoginBody;
import com.atguigu.security.demo.demo.domain.AjaxResult;
import com.atguigu.security.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @ClassName: HelloController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:14
 * @Blog: 暂无
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping("/captchaImage")
    public AjaxResult captchaImage(){
        AjaxResult ajaxResult = AjaxResult.success();
        //不输入验证码
        ajaxResult.put("captchaOnOff",false);
        return ajaxResult;
    }

    // LoginService实现在下面一个代码块
    @Autowired
    LoginService loginService;

    // login登录成功后会返回前端一个token作为用户的标识. 这里我们先实现一个伪token逻辑, 方便后续更新.
    @PostMapping("login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        // 在这里只处理接受前端的login请求, 具体的处理判断, 我们仍交给Security去做
        AjaxResult ajax;
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        if (token == null || token.equals("")) {
            // 登录失败则返回空字串, 所以直接error, 让前端打印一下就行.
            ajax = AjaxResult.error("密码错误");
        } else {
            // 账号密码正确则加入token
            ajax = AjaxResult.success();
            ajax.put("token", token);
        }
        return ajax;
    }

}
