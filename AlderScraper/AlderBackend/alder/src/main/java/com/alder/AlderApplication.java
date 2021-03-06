package com.alder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages =  {"com.locpol.alder.controller", "com.locpol.alder.repository"})
public class AlderApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlderApplication.class, args);
	}

}
