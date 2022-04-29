package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dao.User;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.Result;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;

/**
 * @author wzk
 * @date 2022/4/28 18:38
 */
@Repository
public interface IUserService extends IService<User> {

    Result login(LoginFormDTO loginFormDTO, HttpSession session);
}
