package com.github.joanersoncosta.apisecurity.credencial.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.github.joanersoncosta.apisecurity.credencial.domain.ununs.PerfilUsuario;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Perfil")
public class Perfil {
	@MongoId(targetType = FieldType.STRING)
	@Getter
	private String nome;

	public Perfil(String perfil) {
		this.nome = PerfilUsuario.retornaPerfilUsuario(perfil).name();
	}
}