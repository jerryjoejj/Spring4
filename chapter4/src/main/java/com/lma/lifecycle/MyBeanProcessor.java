package com.lma.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 对实例化的类再次进行加工
 */
public class MyBeanProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getColor() == null) {
                System.out.println("MyBeanProcessor.postProcessBeforeInitialization set color black");
                car.setColor("黑色");
            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            Car car = (Car) bean;
            if (car.getMaxSpeed() >= 200) {
                System.out.println("MyBeanProcessor.postProcessAfterInitialization set speed to 200");
                car.setMaxSpeed(200);
            }
        }

        return bean;
    }
}
