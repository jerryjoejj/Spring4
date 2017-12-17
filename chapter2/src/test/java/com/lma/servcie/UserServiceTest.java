package com.lma.servcie;

import com.lma.domain.User;
import com.lma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@ContextConfiguration("classpath*:/spring-config.xml")
public class UserServiceTest extends AbstractTestNGSpringContextTests {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void hasMatchUser() {
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "1111");
        Assert.assertTrue(b1);
        Assert.assertTrue(b2);
    }

    @Test
    public void findUserByUserName() {
        User user = userService.findUserByName("admin");
        Assert.assertEquals(user.getUserName(), "admin");
    }
}
