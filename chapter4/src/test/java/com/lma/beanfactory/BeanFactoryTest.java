package com.lma.beanfactory;

import com.lma.reflect.Car;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.io.IOException;

public class BeanFactoryTest {

    @Test
    public void getBean() throws Exception {
        // init resource
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource res = resolver.getResource("classpath:spring-config.xml");
        System.out.println(res.getURL());

        // init factory
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(res);
        System.out.println("init factory");

        // get bean
        Car car = factory.getBean("car", Car.class);
        System.out.println(car);
        car.introduce();
    }
}
