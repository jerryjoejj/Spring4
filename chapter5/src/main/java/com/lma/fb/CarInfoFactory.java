package com.lma.fb;

import com.lma.injectfun.Car;
import org.springframework.beans.factory.FactoryBean;

public class CarInfoFactory implements FactoryBean<Car> {


    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public Car getObject() throws Exception {
        Car car = new Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setColor(infos[1]);
        car.setColor(infos[2]);
        return car;
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
