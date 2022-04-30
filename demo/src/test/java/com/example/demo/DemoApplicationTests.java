package com.example.demo;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import com.example.demo.dto.LoginFormDTO;
import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.dto.Result;
import com.example.demo.service.IUserService;
import com.example.demo.utils.PasswordEncoder;
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

    @Test
    void testEncode(){
        String encode1 = PasswordEncoder.encode("123");
        System.out.println(encode1);
        String encode = PasswordEncoder.encode("123");
        Boolean aBoolean = PasswordEncoder.matches(encode, "123");
        System.out.println(aBoolean);
    }
}
