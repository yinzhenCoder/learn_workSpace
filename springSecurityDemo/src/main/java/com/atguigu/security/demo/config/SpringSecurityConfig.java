/**
 * @ClassName: SpringSecurityConfig
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:20
 * @Blog: 暂无
 */

package com.atguigu.security.demo.config;

import com.atguigu.security.demo.service.impl.UserServiceDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @ClassName: SpringSecurityConfig
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 11:20
 * @Blog: 暂无
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserServiceDetailImpl userServiceDetail;

    /**
     * 配置密码加密方式, 在这里为了演示, 我们先使用不加密的方式.
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 强散列哈希加密实现
     */
   /* @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
*/

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //初始化密码角色
        /*auth.inMemoryAuthentication()
                //username: admin1
                //password: 123456
                .withUser("admin1").password("123456").roles("admin")
                .and()
                .withUser("admin2").password("654321").roles("user");*/

        auth.userDetailsService(userServiceDetail)
                .passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 允许任何人访问loginPage, Security 不保护这两个资源.
        http.authorizeRequests().antMatchers("/login","/captchaImage", "login.html")
                .permitAll().anyRequest().authenticated()
                .and()
                // 让security认准自定义的登录页
                .formLogin().loginPage("/loginPage")
                // 登录操作
                .loginProcessingUrl("/authentication/form")
                // 失败后跳转
                .failureUrl("/login?error")
                // 成功后
                .defaultSuccessUrl("/hello")
                // username和password的参数名, 与html中的name一致
                .usernameParameter("username")
                .passwordParameter("password")
                .permitAll();
        // 如果自定义login页面, 需要禁用csrf验证
        // 如果不禁用, security会认为我们自定义的登录操作是非法入侵.
        http.csrf().disable();
        // 添加logout配置, 这样用户输入localhost:8080/logout就会退出登录状态,
        // 然后跳转到localhost:8080/login?logout
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");

    }


    /**
     * 解决 无法直接注入 AuthenticationManager
     * 在我们的SecurityConfig类里,我们追加一个注入器. 让Spring管理这个登陆账号密码比对器.
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }



}
