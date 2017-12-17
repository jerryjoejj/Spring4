package com.lma.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class MagicBossTest {

    @Test
    public void testMagicBoss() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MagicBoss boss = (MagicBoss) context.getBean("magicBoss");
        System.out.println(boss.getCar().getBrand());
    }

}
