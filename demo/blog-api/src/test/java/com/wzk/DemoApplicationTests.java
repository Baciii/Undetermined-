package com.wzk;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.wzk.dao.SysUser;
import com.wzk.dto.LoginUserVo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


@SpringBootTest
class DemoApplicationTests {
    @Test
    public void testToken(){
        byte[] key="123".getBytes();
        Map<String, Object> user = new HashMap<>();
        user.put("account","123");
        user.put("password","123");
        String token = JWTUtil.createToken(user, key);
        boolean verify = JWTUtil.verify(token, key);
        System.out.println(verify);
        JWT jwt = JWTUtil.parseToken(token);
        JSONObject payloads = jwt.getPayloads();
        System.out.println(payloads.get("account"));
    }

    @Test
    public void testBean(){
        SysUser sysUser = new SysUser();
        sysUser.setAccount("123");
        sysUser.setPassword("516");
        sysUser.setNickname("8888");
        sysUser.setAvatar("123123123");


        String s = JSONUtil.toJsonStr(sysUser);
        System.out.println(s);

        LoginUserVo loginUserVo = BeanUtil.copyProperties(sysUser, LoginUserVo.class);
        System.out.println(loginUserVo);
        String s1 = JSONUtil.toJsonStr(loginUserVo);
        System.out.println(s1);
    }
}
