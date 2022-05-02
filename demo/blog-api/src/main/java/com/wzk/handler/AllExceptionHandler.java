package com.wzk.handler;

import com.wzk.dto.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wzk
 * @date 2022/5/1 23:07
 */
// @ControllerAdvice 对加了@Controller注解的方法进行拦截处理 AOP的实现
@ControllerAdvice
public class AllExceptionHandler {
    //进行异常处理，处理Exception.clas的异常
    @ResponseBody
    public Result doException(Exception ex){
        ex.printStackTrace();
        return Result.fail("系统异常");
    }
}
