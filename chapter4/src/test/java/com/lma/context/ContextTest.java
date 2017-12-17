package com.lma.context;

import com.lma.config.Beans;
import com.lma.reflect.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextTest {

    // ApplicationContext context1 = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
    // ApplicationContext context2 = new FileSystemXmlApplicationContext("spring-config.xml");

    @Test
    public void getBean1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class); // 注解类配置文件
        Car car = (Car) context.getBean("car");
        Assert.assertNotNull(car);
    }

    @Test
    public void getBean2() {
        // groovy配置文件
        ApplicationContext context = new GenericGroovyApplicationContext("classpath:groovy-beans.groovy");
        Car car = (Car) context.getBean("car");
        System.out.println(car);
    }

}
