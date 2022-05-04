package com.wzk.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wzk.dao.SysUser;
import com.wzk.dto.LoginForm;
import com.wzk.dto.Result;
import com.wzk.service.LoginService;
import com.wzk.service.SysUserService;
import com.wzk.utils.JWTUtils;
import com.wzk.utils.PasswordEncoder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author wzk
 * @date 2022/5/2 11:20
 */
@Service
//@Transactional //添加事务进行回滚
public class LoginServiceImpl implements LoginService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private SysUserService sysUserService;

    @Override
    public Result login(LoginForm loginForm) {
        /**
         * 1.检查参数是否合法
         * 2.根据用户名和密码查询 是否存在
         * 3.如果不存在 登录失败
         * 4.如果存在 使用jwt生成token 返回给前端
         * 5.token放入redis当中 设置过期时间
         * （登录认证的时候 先认证token是否合法 再去redis中认证是否存在）
         */
        String account = loginForm.getAccount();
        String password = loginForm.getPassword();
        if(StrUtil.isBlank(account)||StrUtil.isBlank(password)){
            return Result.fail("账号或者密码不能为空");
        }
        SysUser sysUser = sysUserService.findUserByAccount(account);
        if(sysUser==null){
            return Result.fail("用户不存在");
        }
        Boolean matches = PasswordEncoder.matches(sysUser.getPassword(), password);
        if(!matches){
            return Result.fail("用户或密码错误");
        }

        String token = JWTUtils.createToken(sysUser);

        stringRedisTemplate.opsForValue().set("login:token:"+token, JSONUtil.toJsonStr(sysUser),1L, TimeUnit.DAYS);
        return Result.ok(token);
    }

    @Override
    public SysUser checkToken(String token) {
        if(StrUtil.isBlank(token)){
            return null;
        }
        //仅作判断token是否合法
        Boolean aBoolean = JWTUtils.parseToken(token);
        if(!aBoolean){
            return null;
        }
        String userJson = stringRedisTemplate.opsForValue().get("login:token" + token);
        SysUser sysUser = JSONUtil.toBean(userJson, SysUser.class);
        return sysUser;
    }

    @Override
    public Result logout(String token) {
        stringRedisTemplate.delete("login:token"+token);
        return Result.ok("退出登录成功");
    }

    @Override
    public Result register(LoginForm loginForm) {
        /**
         * 1.判断参数是否合法
         * 2.判断用户是否存在 存在说明用户已被注册
         * 3.不存在，注册用户
         * 4.生成token
         * 5.存入redis\
         * 6.
         */
        String account = loginForm.getAccount();
        String password = loginForm.getPassword();
        String againPassword = loginForm.getAgainPassword();
        String nickname = loginForm.getNickname();
        if(StrUtil.isBlank(account)||StrUtil.isBlank(password)
            ||StrUtil.isBlank(againPassword)||StrUtil.isBlank(nickname)
        ){
            return Result.fail("不能为空");
        }
        if(!password.equals(againPassword)){
            return Result.fail("两次密码不同");
        }

        SysUser sysUser = sysUserService.findUserByAccount(account);
        if(sysUser==null){
            return Result.fail("该用户已被注册");
        }
        sysUser = sysUserService.findUserByNickName(nickname);
        if(sysUser!=null){
            return Result.fail("该昵称已被使用");
        }
        sysUser = new SysUser();
        sysUser.setNickname(nickname);
        sysUser.setAccount(account);
        sysUser.setPassword(PasswordEncoder.encode(password));
        sysUser.setCreateDate(System.currentTimeMillis());
        sysUser.setLastLogin(System.currentTimeMillis());
        sysUser.setDeleted(0);
        sysUser.setAdmin(1);
        sysUser.setAvatar("");
        sysUser.setEmail("");
        sysUser.setStatus("");
        sysUser.setSalt("");
        sysUserService.saveOrUpdate(sysUser);

        String token = JWTUtils.createToken(sysUser);
        stringRedisTemplate.opsForValue().set("login:token"+token,JSONUtil.toJsonStr(sysUser),1L,TimeUnit.DAYS);
        return Result.ok(token);
    }
}
