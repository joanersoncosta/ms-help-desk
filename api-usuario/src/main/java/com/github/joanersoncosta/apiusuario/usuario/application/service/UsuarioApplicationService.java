package com.github.joanersoncosta.apiusuario.usuario.application.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;
import com.github.joanersoncosta.hdcommonslib.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;
	
	@Override
	public UsuarioNovoResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest) {
		log.debug("[start] UsuarioApplicationService - criaNovoUsuario");
		log.debug("[usuarioRequest] {}", usuarioRequest.toString());
		Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest));
		log.debug("[finish] UsuarioApplicationService - criaNovoUsuario");
		return new UsuarioNovoResponse(usuario);
	}

	@Override
	public UsuarioResponse buscaUsuarioPorId(UUID idUsuario) {
		log.debug("[start] UsuarioApplicationService - buscaUsuarioPorId");
		log.debug("[idUsuario] {}", idUsuario);
		UsuarioResponse usuarioResponse = usuarioRepository.buscaUsuarioPorId(idUsuario)
				.map(UsuarioResponse::new)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Úsuario não encontrado!"));
		log.debug("[finish] UsuarioApplicationService - buscaUsuarioPorId");
		return usuarioResponse;
	}
}