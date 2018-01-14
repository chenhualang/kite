package com.zhong.kite.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/spring-kite-biz.xml")
public class KiteApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(KiteApplication.class, args);
    }
}
