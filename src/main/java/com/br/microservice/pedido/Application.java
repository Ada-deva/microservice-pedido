package com.br.microservice.pedido;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableCaching
@EnableRabbit
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
