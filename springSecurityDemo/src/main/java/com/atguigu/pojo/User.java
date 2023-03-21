/**
 * @ClassName: User
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 15:07
 * @Blog: 暂无
 */

package com.atguigu.pojo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 *
 * @ClassName: User
 * @Description:
 * @author: 千山
 * @date: 2023-03-20 15:07
 * @Blog: 暂无
 */
@Data
public class User implements UserDetails {

    private Integer id;

    private String username;

    private String password;

    private Integer age;

    private String name;

    private String email;


    /**
     * 账户是否未过期,过期无法验证
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 指定用户是否解锁,锁定的用户无法进行身份验证
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 指示是否已过期的用户的凭据(密码),过期的凭据防止认证
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否可用 ,禁用的用户不能身份验证
     */
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }
}