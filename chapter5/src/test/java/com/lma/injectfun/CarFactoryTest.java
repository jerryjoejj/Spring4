package com.lma.injectfun;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class CarFactoryTest {

    @Test
    public void testCarFactory() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Car car = (Car) context.getBean("car2");
        System.out.println(car.getBrand());
        System.out.println(context.getBean("&car2"));
    }

}
