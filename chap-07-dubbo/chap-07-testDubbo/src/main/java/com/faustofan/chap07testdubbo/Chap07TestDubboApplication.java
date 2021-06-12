package com.faustofan.chap07testdubbo;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class Chap07TestDubboApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(Chap07TestDubboApplication.class, args);
	}
	
}
