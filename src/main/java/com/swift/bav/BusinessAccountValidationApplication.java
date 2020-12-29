package com.swift.bav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.swift"})
public class BusinessAccountValidationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusinessAccountValidationApplication.class, args);
	}

}
