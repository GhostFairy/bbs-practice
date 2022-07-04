package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.demo")
@MapperScan(basePackages = "com.example.demo.*.dao")
@SpringBootApplication
public class BbsPracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbsPracticeApplication.class, args);
	}

}
