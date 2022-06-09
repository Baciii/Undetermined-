package com.wzk.utils;

import com.wzk.dao.SysUser;

/**
 * @author wzk
 * @date 2022/5/5 15:27
 */
public class UserThreadLocal {
    private UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get(){
        return LOCAL.get();
    }

    public static void remove(){
        LOCAL.remove();
    }
}
