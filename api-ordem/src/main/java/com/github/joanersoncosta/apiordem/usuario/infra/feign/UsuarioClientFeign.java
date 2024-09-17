package com.github.joanersoncosta.apiordem.usuario.infra.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

@FeignClient(value = "api-usuario", path = "/api/v1/usuario")
public interface UsuarioClientFeign {

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/{idUsuario}")
	UsuarioResponse buscaUsuarioPorId(@PathVariable(value = "idUsuario") UUID idUsuario);

}