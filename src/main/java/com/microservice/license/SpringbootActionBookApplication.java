package com.microservice.license;

import com.microservice.license.Controller.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringbootActionBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootActionBookApplication.class, args);
		System.out.println("Application Started!!");
	}

}
