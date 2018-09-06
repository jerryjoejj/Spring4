package com.lma.dao;

import com.lma.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private static final String MATCH_COUNT = "select count(*) from t_user where user_name = ? and password = ?";
    private static final String FIND_BY_USERNAME = "select * from t_user where user_name = ?";
    private static final String UPDATE_LOGIN_INFO = "update t_user set last_visit = ?, last_ip = ?, credits = ? where user_id = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public User findByUserName(String userName) {
        final User user = new User();
        jdbcTemplate.query(FIND_BY_USERNAME, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateLoginInfo(User user) {
        jdbcTemplate.update(UPDATE_LOGIN_INFO,
                new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }

    public int getMatchCount(String userName, String password) {
        return jdbcTemplate.queryForObject(MATCH_COUNT, new Object[]{userName, password}, Integer.class);
    }
}
