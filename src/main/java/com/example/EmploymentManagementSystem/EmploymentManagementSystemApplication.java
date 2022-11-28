package com.example.EmploymentManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.EmploymentManagementSystem.config.EmsConfig;
import com.example.EmploymentManagementSystem.model.PaySlip;

@SpringBootApplication(scanBasePackages = "com.example.EmploymentManagementSystem")
public class EmploymentManagementSystemApplication {

	public static void main(String[] args) {
		 SpringApplication.run(EmploymentManagementSystemApplication.class,
				args);

	}
}
