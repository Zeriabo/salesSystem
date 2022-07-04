package com.sys.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@ComponentScan({"com.sys.controller"})

@SpringBootApplication
@RestController
public class SalesSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
	
	}

}
