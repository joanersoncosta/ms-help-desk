package com.github.joanersoncosta.apiusuario.usuario.domain;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.joanersoncosta.hdcommonslib.usuario.enuns.PerfilUsuario;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;
import nonapi.io.github.classgraph.json.Id;

@With
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Usuario")
public class Usuario {

	@Id
	private UUID idUsuario;
	private String nome;
	@Indexed(unique = true)
	private String email;
	private String senha;
	private Set<PerfilUsuario> perfil;
}