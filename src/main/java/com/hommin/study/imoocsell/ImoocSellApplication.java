package com.hommin.study.imoocsell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.hommin.study.imoocsell.mapper")
public class ImoocSellApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImoocSellApplication.class, args);
    }
}
