package com.icbc.restfulservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@MapperScan("com.icbc.restfulservice.dao")
public class DemoApplication{

    public static void main(String[] args){
        SpringApplication.run(DemoApplication.class, args);
    }

}
