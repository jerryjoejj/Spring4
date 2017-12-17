package com.lma.service;

import com.lma.dao.LoginLogDao;
import com.lma.dao.UserDao;
import com.lma.domain.LoginLog;
import com.lma.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    public boolean hasMatchUser(String userName, String password) {
        return userDao.getMatchCount(userName, password) > 0;
    }

    public User findUserByName(String userName) {
        return userDao.findByUserName(userName);
    }

    /**
     * 登陆成功，更新登陆信息，写入登陆日志
     * @param user
     */
    @Transactional // 声明事务
    public void loginSuccess(User user) {
        user.setCredits(user.getCredits() + 5);
        LoginLog loginLog = new LoginLog();
        loginLog.setIp(user.getLastIp());
        loginLog.setUserId(user.getUserId());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);
        loginLogDao.insertLoginLog(loginLog);
    }
}
