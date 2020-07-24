package com.ccc.restmvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ccc.restmvc.mapper")
public class RestMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMvcApplication.class, args);
	}

}
