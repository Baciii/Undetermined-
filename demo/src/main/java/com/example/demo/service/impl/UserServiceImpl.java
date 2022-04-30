package com.example.demo.service.impl;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.json.JSONUtil;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.User;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.dto.Result;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.example.demo.utils.PasswordEncoder;
import org.springframework.stereotype.Service;


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

        //密码匹配
        Boolean matches = PasswordEncoder.matches(user.getPassword(), password);

        if(matches){
            String jsonUser = JSONUtil.toJsonStr(user);
            return Result.ok(jsonUser);
        }

        return Result.fail("密码错误");
    }

    public Result register(RegisterFormDTO registerFormDTO) {
        String account = registerFormDTO.getAccount();
        User user = query().eq("account", account).one();
        if(user!=null){
            return Result.fail("该账户已存在");
        }
        String password = registerFormDTO.getPassword();
        String again_password = registerFormDTO.getAgain_password();
        if(!password.equals(again_password)){
            return Result.fail("两次密码不一致");
        }
        User user1 = new User();
        user1.setAccount(account);
        //密码加密
        String encode = PasswordEncoder.encode(password);
        user1.setPassword(encode);

        saveOrUpdate(user1);
        return Result.ok("注册成功");
    }

}
