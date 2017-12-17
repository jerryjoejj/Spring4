package com.lma.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@EnableAutoConfiguration
public class BBSDemo {

    @RequestMapping("/")
    public String index() {
        return "欢迎访问尼玛论坛";
    }

//    public static void main(String[] args) {
//        SpringApplication.run(BBSDemo.class, args);
//    }

}
