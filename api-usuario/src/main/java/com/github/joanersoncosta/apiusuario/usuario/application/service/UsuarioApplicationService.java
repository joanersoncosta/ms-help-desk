package com.github.joanersoncosta.apiusuario.usuario.application.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.joanersoncosta.apiusuario.credencial.application.service.CredencialService;
import com.github.joanersoncosta.apiusuario.credencial.domain.CredencialRequest;
import com.github.joanersoncosta.apiusuario.handler.APIException;
import com.github.joanersoncosta.apiusuario.usuario.application.api.request.AtualizaUsuarioRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.apiusuario.usuario.application.service.mapper.UsuarioMapper;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class UsuarioApplicationService implements UsuarioService {
	private final UsuarioRepository usuarioRepository;
	private final UsuarioMapper usuarioMapper;
	private final CredencialService credencialService;

	@Override
	public UsuarioNovoResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest) {
		log.debug("[start] UsuarioApplicationService - criaNovoUsuario");
		log.debug("[usuarioRequest] {}", usuarioRequest.toString());
		Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest));
		credencialService.criaNovaCredencial(new CredencialRequest(usuarioRequest.withSenha(new BCryptPasswordEncoder().encode(usuarioRequest.senha()))));
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
		UsuarioResponse usuarioResponse = usuarioMapper.converteUsuarioResponse(detalhaUsuario(idUsuario));
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

	@Override
	public List<UsuarioResponse> buscaTodosOsUsuarios() {
		log.debug("[start] UsuarioApplicationService - buscaTodosOsUsuarios");
		List<Usuario> usuarios = usuarioRepository.buscaTodosOsUsuarios();
		List<UsuarioResponse> usuariosResponse = usuarios.stream()
				.map(usuario -> usuarioMapper.converteUsuarioResponse(usuario)).collect(Collectors.toList());
		log.debug("[finish] UsuarioApplicationService - buscaTodosOsUsuarios");
		return usuariosResponse;
	}

	@Override
	public UsuarioResponse atualizaDadosDoUsuario(UUID idUsuario, AtualizaUsuarioRequest usuarioRequest) {
		log.debug("[start] UsuarioApplicationService - atualizaDadosDoUsuario");
		Usuario  usuario = detalhaUsuario(idUsuario);
		usuarioRepository.validaDadosDoUsuario(usuario.getIdUsuario(), usuarioRequest.email());
		usuario.editaDados(usuarioRequest);
		usuarioRepository.salva(usuario);
		log.debug("[finish] UsuarioApplicationService - atualizaDadosDoUsuario");
		return usuarioMapper.converteUsuarioResponse(usuario);
	}
}