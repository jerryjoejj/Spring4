package com.lma.config;

import com.lma.reflect.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {

    @Bean(name = "car")
    public Car buildCar() {
        Car car = new Car();
        car.setBrand("宝马");
        car.setColor("黑色");
        car.setMaxSpeed(200);
        return car;
    }

}
