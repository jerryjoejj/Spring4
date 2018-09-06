package com.lma.dao;

import com.lma.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {

    private static final String INSERT_LOGIN_LOG = "INSERT INTO t_login_log(user_id, ip, login_datetime) VALUES (?, ?, ?)";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog) {
        jdbcTemplate.update(INSERT_LOGIN_LOG, loginLog.getUserId(), loginLog.getIp(), loginLog.getIp());
    }
}
