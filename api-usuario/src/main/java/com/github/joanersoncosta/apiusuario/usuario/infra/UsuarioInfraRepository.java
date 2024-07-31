package com.github.joanersoncosta.apiusuario.usuario.infra;

import java.util.Optional;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiusuario.usuario.application.repository.UsuarioRepository;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;
import com.github.joanersoncosta.hdcommonslib.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
	private final UsuarioSpringMongoDBRepository usuarioSpringMongoDBRepository;

	@Override
	public Usuario salva(Usuario usuario) {
		log.debug("[start] UsuarioInfraRepository - salva");
		try {
			usuarioSpringMongoDBRepository.save(usuario);
		} catch (DataIntegrityViolationException ex) {
			throw APIException.build(HttpStatus.BAD_REQUEST, "Úsuario já cadastrado.", ex);
		}
		log.debug("[finish] UsuarioInfraRepository - salva");
		return usuario;
	}

	@Override
	public Optional<Usuario> buscaUsuarioPorId(UUID idUsuario) {
		log.debug("[start] UsuarioInfraRepository - buscaUsuarioPorId");
		Optional<Usuario> usuario = usuarioSpringMongoDBRepository.findById(idUsuario);
		log.debug("[finish] UsuarioInfraRepository - buscaUsuarioPorId");
		return usuario;
	}
}