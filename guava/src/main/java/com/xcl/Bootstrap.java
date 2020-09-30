package com.xcl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xcl.mapper")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class,args);
    }
}
