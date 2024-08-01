package com.github.joanersoncosta.apiusuario.credencial.infra;

import org.springframework.stereotype.Repository;

import com.github.joanersoncosta.apiusuario.credencial.application.repository.CredencialRepository;
import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;

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
}