package com.wzk.service;

import com.wzk.dao.SysUser;
import com.wzk.dto.LoginForm;
import com.wzk.dto.Result;

/**
 * @author wzk
 * @date 2022/5/2 11:19
 */
public interface LoginService {
    /**
     * 登录功能
     * @param loginForm
     * @return
     */
    Result login(LoginForm loginForm);

    /**
     * 检查token
     * @param token
     * @return
     */
    SysUser checkToken(String token);

    /**
     * 退出登录
     * @param token
     * @return
     */
    Result logout(String token);

    /**
     * 注册功能
     * @param loginForm
     * @return
     */
    Result register(LoginForm loginForm);
}
