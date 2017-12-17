package com.lma.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;

import java.beans.PropertyDescriptor;

/**
 * 拓展InstantiationAwareBeanPostProcessorAdapter
 */
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /**
     * 实例化bean之前调用
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }

        return null;
    }

    /**
     * 实例化bean后调用
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if ("car".equals(beanName)) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }
        return true;
    }

    /**
     * 实例化bean过程中调用
     */
    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, PropertyDescriptor[] pds, Object bean, String beanName) throws BeansException {

        if ("car".equals(beanName)) {
            System.out.println("MyInstantiationAwareBeanPostProcessor.postProcessPropertyValues");
        }
        return pvs;
    }
}
