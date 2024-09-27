package com.github.joanersoncosta.apiordem.usuario.infra.feign;

import java.util.UUID;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.joanersoncosta.apiordem.usuario.infra.feign.client.UsuarioResponse;

@FeignClient(value = "api-usuario", url = "localhost:8080", path = "/v1/usuario")
public interface UsuarioClientFeign {

	@GetMapping(path = "/{idUsuario}")
	UsuarioResponse buscaUsuarioPorId(@PathVariable(value = "idUsuario") UUID idUsuario);

}