package com.bbd_coffee_app.BBD_Coffee_Application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BbdCoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbdCoffeeApplication.class, args);
	}
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}