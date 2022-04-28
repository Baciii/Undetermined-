package controller;


import dto.LoginFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.IUserService;

import javax.servlet.http.HttpSession;


/**
 * @author wzk
 * @date 2022/4/28 18:21
 */
@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/admin")
    public void Login(@RequestBody LoginFormDTO loginForm, HttpSession session){
        userService.login(loginForm,session);
    }

}
