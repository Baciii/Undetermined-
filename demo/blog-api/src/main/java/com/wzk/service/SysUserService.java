package com.wzk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzk.dao.SysUser;
import com.wzk.dto.Result;

/**
 * @author wzk
 * @date 2022/5/1 22:33
 */
public interface SysUserService extends IService<SysUser> {
    Result findUserByToken(String token);

    SysUser findUserById(Long id);

    SysUser findUserByAccountAndPwd(String account,String password);

    SysUser findUserByAccount(String account);

    SysUser findUserByNickName(String nickname);
}
