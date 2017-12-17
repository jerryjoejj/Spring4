package com.lma.lifecycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class BeanLifeCycle {

    private static void lifeCycleBeanFactory() {
        // 读取配置文件，并实例化容器
        Resource res = new ClassPathResource("beans.xml");
        BeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((DefaultListableBeanFactory) beanFactory);

        reader.loadBeanDefinitions(res);

        // 向容器中注册MyBeanProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyBeanProcessor());
        // 向容器中注册MyInstantiationAwareBeanPostProcessor后处理器
        ((ConfigurableBeanFactory) beanFactory).addBeanPostProcessor(new MyInstantiationAwareBeanPostProcessor());

        // 第一次从容器中获取bean
        Car car1 = (Car) beanFactory.getBean("car");
        car1.introduce();
        car1.setColor("red");
        // 第二次获取与第一次是同一个对象，直接从缓存池中获取
        Car car2 = (Car) beanFactory.getBean("car");
        System.out.println(car1 == car2);
        // 销毁容器
        ((DefaultListableBeanFactory) beanFactory).destroySingletons();
    }

    public static void main(String[] args) {
        lifeCycleBeanFactory();
    }

}
