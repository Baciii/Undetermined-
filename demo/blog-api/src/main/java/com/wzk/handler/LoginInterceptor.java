package com.wzk.handler;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.wzk.dao.SysUser;
import com.wzk.dto.Result;
import com.wzk.service.LoginService;
import com.wzk.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

/**
 * @author wzk
 * @date 2022/5/5 14:25
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Resource
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /**
         * 1.需要判断请求的接口路径是否为 HandlerMethod（controller方法）
         * 2.判断token是否为空，如果为空，未登录
         * 3.如果token不为空，登录验证 loginService checkToken
         * 4.如果认证成功 放行
         */
        if(!(handler instanceof HandlerMethod)){
            //放行静态目录
            return true;
        }
        String token = request.getHeader("Authorization");


        log.info("===============request start================");
        String requestURI = request.getRequestURI();
        log.info("request uri:{}",requestURI);
        log.info("request method:{}",request.getMethod());
        log.info("token:{}",token);
        log.info("===============request end================");


        if(StrUtil.isBlank(token)){
            Result result = Result.fail("未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSONUtil.toJsonStr(result));
            return false;
        }
        SysUser sysUser = loginService.checkToken(token);
        if(sysUser==null){
            Result result = Result.fail("未登录");
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().print(JSONUtil.toJsonStr(result));
            return false;
        }
        UserThreadLocal.put(sysUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //删除ThreadLocal的信息，以防内存泄露
        UserThreadLocal.remove();
    }
}
