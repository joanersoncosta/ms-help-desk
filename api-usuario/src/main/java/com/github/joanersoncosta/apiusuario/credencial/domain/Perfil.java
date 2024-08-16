package com.github.joanersoncosta.apiusuario.credencial.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.github.joanersoncosta.apiusuario.credencial.domain.enuns.PerfilUsuario;

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