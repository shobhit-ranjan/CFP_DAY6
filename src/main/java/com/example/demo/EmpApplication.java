package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmpApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EmpApplication.class, args);
		log.info("Employee Application started! in {} Environment",  context.getEnvironment().getProperty("environment"));
	}

}
