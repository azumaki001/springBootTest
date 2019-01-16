package com.test.springTest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.test.springTest.mybatis")
public class SpringTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTestApplication.class, args);
	}

}

