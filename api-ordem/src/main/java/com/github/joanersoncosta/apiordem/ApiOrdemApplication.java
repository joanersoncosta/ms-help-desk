package com.github.joanersoncosta.apiordem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class ApiOrdemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiOrdemApplication.class, args);
	}

}
