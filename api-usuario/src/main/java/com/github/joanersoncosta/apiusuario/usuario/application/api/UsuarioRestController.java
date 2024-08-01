package com.github.joanersoncosta.apiusuario.usuario.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.service.UsuarioService;
import com.github.joanersoncosta.hdcommonslib.usuario.domain.request.AtualizaUsuarioRequest;
import com.github.joanersoncosta.hdcommonslib.usuario.domain.request.UsuarioNovoRequest;
import com.github.joanersoncosta.hdcommonslib.usuario.domain.response.UsuarioResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequiredArgsConstructor
public class UsuarioRestController implements UsuarioAPI {
	private final UsuarioService usuarioService;
	
	@Override
	public UsuarioNovoResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest) {
		log.debug("[start] UsuarioRestController - criaNovoUsuario");
		UsuarioNovoResponse usuarioCriado = usuarioService.criaNovoUsuario(usuarioRequest);
		log.debug("[finish] UsuarioRestController - criaNovoUsuario");
		return usuarioCriado;
	}

	@Override
	public UsuarioResponse buscaUsuarioPorId(UUID idUsuario) {
		log.debug("[start] UsuarioRestController - buscaUsuarioPorId");
		UsuarioResponse usuarioResponse = usuarioService.buscaUsuarioPorId(idUsuario);
		log.debug("[finish] UsuarioRestController - buscaUsuarioPorId");
		return usuarioResponse;
	}

	@Override
	public List<UsuarioResponse> buscaTodosOsUsuarios() {
		log.debug("[start] UsuarioRestController - buscaTodosOsUsuarios");
		List<UsuarioResponse> usuariosResponse = usuarioService.buscaTodosOsUsuarios();
		log.debug("[finish] UsuarioRestController - buscaTodosOsUsuarios");
		return usuariosResponse;
	}

	@Override
	public UsuarioResponse atualizaDadosDoUsuario(UUID idUsuario, AtualizaUsuarioRequest usuarioRequest) {
		log.debug("[start] UsuarioRestController - atualizaDadosDoUsuario");
		UsuarioResponse usuarioResponse = usuarioService.atualizaDadosDoUsuario(idUsuario, usuarioRequest);
		log.debug("[finish] UsuarioRestController - atualizaDadosDoUsuario");
		return usuarioResponse;
	}
}
