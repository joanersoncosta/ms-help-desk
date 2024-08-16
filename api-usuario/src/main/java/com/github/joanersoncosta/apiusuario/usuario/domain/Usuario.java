package com.github.joanersoncosta.apiusuario.usuario.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.AtualizaUsuarioRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.With;

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
	
	public Usuario(UsuarioNovoRequest usuarioRequest) {
		this.idUsuario = UUID.randomUUID();
		this.nome = usuarioRequest.nome();
		this.email = usuarioRequest.email();
	}

	public void editaDados(AtualizaUsuarioRequest usuarioRequest) {
		this.nome = usuarioRequest.nome();
		this.email = usuarioRequest.email();
	}
}