package com.swift.bav.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class SpringBootDemo {
	
		@RequestMapping("/{usrId}")
		public String getName() {
			return "Business Account Validation";
		}

}
