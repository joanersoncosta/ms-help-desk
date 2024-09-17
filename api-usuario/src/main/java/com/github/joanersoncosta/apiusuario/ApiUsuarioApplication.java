package com.github.joanersoncosta.apiusuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ApiUsuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUsuarioApplication.class, args);
	}

}