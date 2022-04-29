package com.example.demo.service.impl;

import cn.hutool.json.JSONUtil;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.User;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.Result;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author wzk
 * @date 2022/4/28 18:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    public Result login(LoginFormDTO loginFormDTO, HttpSession session) {
        String account = loginFormDTO.getAccount();
        String password = loginFormDTO.getPassword();
        User user = query().eq("account", account).one();

        if(user==null){
            return Result.fail("账号错误");
        }

        if(user.getPassword().equals(password)){
            String jsonUser = JSONUtil.toJsonStr(user);
            return Result.ok(jsonUser);
        }

        return Result.fail("密码错误");
    }
}
