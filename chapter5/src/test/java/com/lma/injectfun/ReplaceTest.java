package com.lma.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class ReplaceTest {

    @Test
    public void testReplace() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Boss1 boss = (Boss1) context.getBean("boss1");
        System.out.println(boss.getCar().getBrand());
    }
}
