package com.lma.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Autowired
    private DaoConfig daoConfig;// 像普通bean注入

    public LoginService loginService() {
        LoginService loginService = new LoginService();
        // 像普通bean一样使用
        loginService.setLoginLogDao(daoConfig.logDao());
        loginService.setUserDao(daoConfig.userDao());
        return loginService;
    }


}
