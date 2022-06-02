package com.wzk.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wzk.dao.SysUser;
import com.wzk.dto.Result;
import com.wzk.dto.UserVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wzk
 * @date 2022/5/1 22:33
 */
public interface SysUserService extends IService<SysUser> {
    UserVo findUserVoByAuthorId(Long authorId);

    Result findUserByToken(String token);

    SysUser findUserById(Long id);

    SysUser findUserByAccountAndPwd(String account,String password);

    SysUser findUserByAccount(String account);

    SysUser findUserByNickName(String nickname);
}
