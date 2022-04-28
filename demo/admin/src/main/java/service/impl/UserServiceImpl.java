package service.impl;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import dao.User;
import dto.LoginFormDTO;
import dto.Result;
import mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.IUserService;

import javax.servlet.http.HttpSession;

/**
 * @author wzk
 * @date 2022/4/28 18:39
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(LoginFormDTO loginFormDTO, HttpSession session) {
        String account = loginFormDTO.getAccount();
        String password = loginFormDTO.getPassword();
        User user = query().eq("account", account).one();

        if(user==null){
            return Result.fail("账号错误");
        }

        if(user.getPassword()==password){
            String jsonUser = JSONUtil.toJsonStr(user);
            return Result.ok(jsonUser);
        }

        return Result.fail("密码错误");
    }
}
