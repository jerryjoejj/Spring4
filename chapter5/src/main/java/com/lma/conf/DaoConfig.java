package com.lma.conf;

import com.lma.dao.LoginLogDao;
import com.lma.dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoConfig {

    @Bean
    public UserDao userDao() {
        return new UserDao();
    }

    @Bean
    public LoginLogDao logDao() {
        return new LoginLogDao();
    }

}
