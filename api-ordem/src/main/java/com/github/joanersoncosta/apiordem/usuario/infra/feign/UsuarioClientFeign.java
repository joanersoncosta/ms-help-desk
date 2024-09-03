package com.github.joanersoncosta.apiordem.usuario.infra.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

import io.swagger.v3.oas.annotations.Parameter;

@FeignClient(name = "api-usuario", url = "https://localhost:8080/api/v1/usuario")
public interface UsuarioClientFeign {

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value  = "/{idUsuario}")
	UsuarioResponse buscaUsuarioPorId(
			@Parameter(description = "Id usuario", required = true, example = "b700b45a-d1ee-41da-95bd-6d477a7c862")
			@PathVariable(value  = "idUsuario") UUID idUsuario);

}