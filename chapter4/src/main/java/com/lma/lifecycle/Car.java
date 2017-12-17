package com.lma.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Car implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {
    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;


    public Car() {
        System.out.println("调用Car的构造函数");
    }

    public Car(String brand, String color, int maxSpeed) {
        this.brand = brand;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    /**
     * BeanFactoryAware实现方法
     * @param beanFactory
     * @throws BeansException
     */
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("调用BeanFactoryAware.setBeanFactory()方法");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware实现方法
     * @param beanName
     */
    public void setBeanName(String beanName) {
        System.out.println("调用BeanNameAware.setBeanName()方法");
        this.beanName = beanName;
    }

    /**
     * InitalizingBean实现方法
     * @throws Exception
     */
    public void afterPropertiesSet() throws Exception {
        System.out.println("调用InitializingBean.afterPropertiesSet()方法");
    }

    /**
     * Disposable实现方法
     * @throws Exception
     */
    public void destroy() throws Exception {
        System.out.println("调用DisposableBean.destory()方法");
    }

    /**
     * 由init-method指定
     * @param maxSpeed
     */
    public void myInit() {
        System.out.println("调用指定初始化方法");
        this.maxSpeed = 240;
    }

    /**
     * 由destory-method指定
     */
    public void myDestory() {
        System.out.println("调用指定销毁方法");
    }

    public void introduce() {
        System.out.println("band:" + brand + ";color:" + color + ";maxSpeed:" + maxSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        System.out.println("调用setBrand方法");
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        System.out.println("调用setColor方法");
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        System.out.println("调用setMaxSpeed方法");
        this.maxSpeed = maxSpeed;
    }


}
