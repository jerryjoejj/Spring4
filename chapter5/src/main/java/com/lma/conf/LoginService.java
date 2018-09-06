package com.lma.conf;

import com.lma.dao.LoginLogDao;
import com.lma.dao.UserDao;

public class LoginService {

    private LoginLogDao loginLogDao;
    private UserDao userDao;

    public LoginLogDao getLoginLogDao() {
        return loginLogDao;
    }

    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
