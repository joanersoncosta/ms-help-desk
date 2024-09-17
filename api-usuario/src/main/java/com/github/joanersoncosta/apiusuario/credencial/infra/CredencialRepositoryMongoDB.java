package com.github.joanersoncosta.apiusuario.credencial.infra;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiusuario.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;
import com.github.joanersoncosta.apiusuario.handler.APIException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CredencialRepositoryMongoDB implements CredencialRepository {
	private final CredencialMongoSpringRepository credencialMongoRepository;

	@Override
	public Credencial salva(Credencial credencial) {
		log.debug("[start] CredencialRepositoryMongoDB - salva");
		credencialMongoRepository.save(credencial);
		log.debug("[finish] CredencialRepositoryMongoDB - salva");
		return credencial;
	}
	
	@Override
	public Credencial buscaCredencialPorUsuario(String usuario) {
		log.debug("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		var credencial = credencialMongoRepository.findByUsuario(usuario)
				.orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Não existe credencial para o úsuario informado!"));
		log.debug("[start] CredencialRepositoryMongoDB - buscaCredencialPorUsuario");
		return credencial;
	}	
}