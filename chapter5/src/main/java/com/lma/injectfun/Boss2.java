package com.lma.injectfun;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class Boss2 implements MethodReplacer {
    public Object reimplement(Object o, Method method, Object[] objects) throws Throwable {
        Car car = new Car();
        car.setBrand("劳斯莱斯");
        return car;
    }
}
