package com.github.joanersoncosta.apiusuario.config.swagger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI customOpenAPI(
			@Value("${springdoc.openapi.title}") final String titlo,
			@Value("${springdoc.openapi.description}") final String descricao,
			@Value("${springdoc.openapi.version}") final String versao) {
		return new OpenAPI()
				.info(new Info()
						.title(titlo)
						.description(descricao)
						.version(versao)
						);
		}
}