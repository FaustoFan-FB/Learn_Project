package com.example.chap03mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.chap03mybatis.mapper")
public class Chap03MybatisApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Chap03MybatisApplication.class, args);
	}
	
}
