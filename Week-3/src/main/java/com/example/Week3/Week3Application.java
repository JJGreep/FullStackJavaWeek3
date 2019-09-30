package com.example.Week3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.Week3.Controllers","com.example.Week3.Models","com.example.Week3.Services"})
public class Week3Application {

	public static void main(String[] args) {
		SpringApplication.run(Week3Application.class, args);
	}

}
