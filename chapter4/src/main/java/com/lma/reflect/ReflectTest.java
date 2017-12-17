package com.lma.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByDefaultConst() throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();// 获取当前类加载器
        Class clazz = classLoader.loadClass("com.lma.reflect.Car"); // 加载类
        Constructor constructor = clazz.getDeclaredConstructor((Class[]) null); // 获取默认无参构造器
        Car car = (Car) constructor.newInstance();// 获取对象

        Method setBrand = clazz.getMethod("setBrand", String.class); // 获取方法
        setBrand.invoke(car, "宝马X5"); // 设置属性
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car, "红色");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car, 200);
        return car;
    }

    public static void main(String[] args) throws Exception {
        Car car = initByDefaultConst();
        car.introduce();
    }
}
