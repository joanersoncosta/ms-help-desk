package com.github.joanersoncosta.apiusuario.usuario.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
	
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	UsuarioNovoResponse criaNovoUsuario(@RequestBody @Valid UsuarioNovoRequest usuarioRequest);

	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value  = "/{idUsuario}")
	UsuarioResponse buscaUsuarioPorId(@PathVariable(value  = "idUsuario") UUID idUsuario);
}