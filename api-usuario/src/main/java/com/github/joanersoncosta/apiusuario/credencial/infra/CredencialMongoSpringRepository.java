package com.github.joanersoncosta.apiusuario.credencial.infra;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.joanersoncosta.apiusuario.credencial.domain.Credencial;

public interface CredencialMongoSpringRepository extends MongoRepository<Credencial, String> {
	Optional<Credencial> findByUsuario(String Usuario);
}
