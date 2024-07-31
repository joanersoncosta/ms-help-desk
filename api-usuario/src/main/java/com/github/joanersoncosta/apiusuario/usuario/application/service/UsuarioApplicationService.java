package com.github.joanersoncosta.apiusuario.usuario.application.service;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.apiusuario.usuario.application.service.mapper.UsuarioMapper;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;
import com.github.joanersoncosta.hdcommonslib.handler.APIException;
import com.github.joanersoncosta.hdcommonslib.usuario.domain.response.UsuarioResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;

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
		UsuarioResponse usuarioResponse = detalhaUsuarioResponse(idUsuario);
		log.debug("[finish] UsuarioApplicationService - buscaUsuarioPorId");
		return usuarioResponse;
	}

	private UsuarioResponse detalhaUsuarioResponse(UUID idUsuario) {
		log.debug("[start] UsuarioApplicationService - detalhaUsuarioResponse");
		UsuarioResponse usuarioResponse = usuarioMapper
				.converteUsuarioResponse(detalhaUsuario(idUsuario));
		log.debug("[finish] UsuarioApplicationService - detalhaUsuarioResponse");
		return usuarioResponse;
	}

	private Usuario detalhaUsuario(UUID idUsuario) {
		log.debug("[start] UsuarioApplicationService - detalhaUsuarioResponse");
		Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Úsuario não encontrado!"));
		log.debug("[finish] UsuarioApplicationService - detalhaUsuarioResponse");
		return usuario;
	}
}