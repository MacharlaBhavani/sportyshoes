package com.sportyshoes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.sportyshoes.*")
public class SportyshoesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportyshoesApiApplication.class, args);
		System.out.println("sporty shoes");
	}

}
