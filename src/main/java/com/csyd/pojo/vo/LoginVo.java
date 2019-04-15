package com.csyd.pojo.vo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by ChengShanyunduo
 * 2019/3/25
 */
public class LoginVo {
    @NotNull(message="用户名不允许为空")
    @Length(min=3,max=16,message="用户名长度不正确!")
    private String username;

    @NotNull(message="密码不允许为空")
    @Length(min=6,max=16,message="密码长度不正确!")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
