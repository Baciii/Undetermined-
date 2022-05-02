package com.wzk.dto;

import lombok.Data;

/**
 * @author wzk
 * @date 2022/5/2 11:21
 */
@Data
/**
 * 登录与注册
 */
public class LoginForm {
    private String account;
    private String password;
    private String againPassword;
    private String nickname;
}
