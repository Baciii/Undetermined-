package com.example.demo;

import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.dto.Result;
import com.example.demo.service.IUserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@MapperScan("com.example.demo.mapper")
class DemoApplicationTests {

    @Resource
    private IUserService userService;

    @Test
    void testLogin() {
        LoginFormDTO loginFormDTO = new LoginFormDTO("123","123");
        Result result = userService.login(loginFormDTO, null);
        System.out.println(result);
    }

    @Test
    void testRegister(){
        RegisterFormDTO registerFormDTO = new RegisterFormDTO("admin","123","123");
        Result result = userService.register(registerFormDTO);
        System.out.println(result);
    }

}
