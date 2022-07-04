package com.sys.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@ComponentScan({"com.sys.controller"})

@SpringBootApplication
@RestController
public class SalesSystemApplication {

	private static final Logger LOGGER=LoggerFactory.getLogger(SalesSystemApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SalesSystemApplication.class, args);
		
		LOGGER.info("Info level log message");
        LOGGER.debug("Debug level log message");
        LOGGER.error("Error level log message");
	}

}
