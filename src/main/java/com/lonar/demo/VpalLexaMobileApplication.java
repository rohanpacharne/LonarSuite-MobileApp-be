package com.lonar.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lonar")
public class VpalLexaMobileApplication {

	public static void main(String[] args) {
		SpringApplication.run(VpalLexaMobileApplication.class, args);
	}

}
