package com.wzk.controller;

import com.wzk.dto.LoginForm;
import com.wzk.dto.Result;
import com.wzk.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/2 11:17
 */
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginForm loginForm){
        //登录 验证用户
        return loginService.login(loginForm);
    }

}
