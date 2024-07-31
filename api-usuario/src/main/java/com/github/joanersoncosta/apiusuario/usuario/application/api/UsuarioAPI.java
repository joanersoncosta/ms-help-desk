package com.github.joanersoncosta.apiusuario.usuario.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	UsuarioResponse criaNovoUsuario(@RequestBody UsuarioNovoRequest usuarioRequest);
}
