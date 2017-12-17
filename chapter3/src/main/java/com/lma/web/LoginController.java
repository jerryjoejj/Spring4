package com.lma.web;

import com.lma.domain.User;
import com.lma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserServicel(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/index.html", ""})
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand) {
        boolean isLoginUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());
        if (!isLoginUser) {// 登陆失败
            return new ModelAndView("login", "error", "登陆失败，用户名或密码错误");
        } else {
            User user = userService.findUserByName(loginCommand.getUserName());
            user.setLastIp(request.getLocalAddr());
            user.setLastVisit(new Date());
            userService.loginSuccess(user);
            request.getSession().setAttribute("user", user);
            return new ModelAndView("main");
        }
    }
}
