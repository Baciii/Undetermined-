package com.wzk.utils;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.wzk.dao.SysUser;

import java.util.Map;

/**
 * @author wzk
 * @date 2022/5/2 14:58
 */
public class JWTUtils {
    private static final byte[] key="123".getBytes();

    public static String createToken(SysUser user){

        Map<String, Object> map = BeanUtil.beanToMap(user);
        String token = JWTUtil.createToken(map, key);
        return token;
    }

    public static Boolean parseToken(String token){
        boolean verify = JWTUtil.verify(token, key);
        return verify;
    }
}
