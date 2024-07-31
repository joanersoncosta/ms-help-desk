package com.github.joanersoncosta.apiusuario.usuario.application.service;

import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest) {
		log.debug("[start] UsuarioApplicationService - criaNovoUsuario");
		Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest));
		log.debug("[finish] UsuarioApplicationService - criaNovoUsuario");
		return new UsuarioResponse(usuario);
	}
}