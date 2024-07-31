package com.github.joanersoncosta.apiusuario.usuario.application.api;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.service.UsuarioService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UsuarioRestController implements UsuarioAPI {
	private final UsuarioService usuarioService;
	
	@Override
	public UsuarioResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest) {
		log.debug("[start] UsuarioRestController - criaNovoUsuario");
		UsuarioResponse usuarioCriado = usuarioService.criaNovoUsuario(usuarioRequest);
		log.debug("[finish] UsuarioRestController - criaNovoUsuario");
		return usuarioCriado;
	}
}
