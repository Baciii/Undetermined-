package com.example.demo.controller;


import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


/**
 * @author wzk
 * @date 2022/4/28 18:21
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("/admin")
    public void Login(@RequestBody LoginFormDTO loginForm, HttpSession session){
        userService.login(loginForm,session);
    }

    @RequestMapping("/register")
    public void Register(@RequestBody RegisterFormDTO registerFormDTO){
        userService.register(registerFormDTO);
    }
}
