package com.wzk.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wzk.dao.SysUser;
import com.wzk.dto.LoginUserVo;
import com.wzk.dto.Result;
import com.wzk.dto.UserVo;
import com.wzk.mapper.SysUserMapper;
import com.wzk.service.LoginService;
import com.wzk.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wzk
 * @date 2022/5/1 22:34
 */
@Service
public class UserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    @Resource
    private LoginService loginService;

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public UserVo findUserVoByAuthorId(Long authorId) {
        SysUser sysUser = sysUserMapper.selectById(authorId);
        return BeanUtil.copyProperties(sysUser,UserVo.class);
    }

    @Override
    public Result findUserByToken(String token) {
        /**
         * 1.token合法校验，是否为空，解析是否成功，redis是否存在
         *
         * 2.如果校验失败 返回错误
         * 3.如果成功 返回LoginUserVo
         */
        SysUser sysUser = loginService.checkToken(token);
        if(sysUser==null){
            return Result.fail("不合法");
        }
        LoginUserVo loginUserVo = new LoginUserVo();
        BeanUtil.copyProperties(sysUser,loginUserVo);

        return Result.ok(loginUserVo);
    }

    @Override
    public SysUser findUserById(Long id) {
        SysUser sysUser = sysUserMapper.selectById(id);
        return sysUser;
    }

    @Override
    public SysUser findUserByAccountAndPwd(String account,String password) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.eq(SysUser::getPassword,password);
        queryWrapper.select(SysUser::getAccount,SysUser::getId,SysUser::getAvatar,SysUser::getNickname);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser findUserByAccount(String account) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount,account);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }

    @Override
    public SysUser findUserByNickName(String nickname) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getNickname,nickname);
        queryWrapper.last("limit 1");
        return sysUserMapper.selectOne(queryWrapper);
    }
}
