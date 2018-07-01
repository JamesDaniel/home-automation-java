package com.home.automation.homeautomation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HomeautomationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeautomationApplication.class, args);
	}
}
