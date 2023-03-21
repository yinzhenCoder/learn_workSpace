/**
 * @ClassName: PageController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:31
 * @Blog: 暂无
 */

package com.atguigu.security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @ClassName: PageController
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:31
 * @Blog: 暂无
 */
@Controller
public class PageController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginPage1")
    // 返回字符串,不进行页面跳转
    @ResponseBody
    public String login1(){
        return "login";
    }

}
