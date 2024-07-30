package com.github.joanersoncosta.apiusuario.usuario.infra;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

public interface UsuarioSpringMongoDBRepository extends MongoRepository<Usuario, UUID>{

}
