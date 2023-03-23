package com.zyw.demo_boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//mybatis， dao（mapper）接口扫描
@MapperScan("com.zyw.demo_boot.dao")
@SpringBootApplication
public class DemoBootApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoBootApplication.class, args) ;
    }

}
