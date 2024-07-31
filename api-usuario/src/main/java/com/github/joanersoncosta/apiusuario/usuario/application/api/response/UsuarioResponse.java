package com.github.joanersoncosta.apiusuario.usuario.application.api.response;

import java.util.Set;
import java.util.UUID;

import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;
import com.github.joanersoncosta.hdcommonslib.usuario.enuns.PerfilUsuario;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UsuarioResponse {
	private final UUID idUsuario;
	private final String nome;
	private final String email;
	private Set<PerfilUsuario> perfil;
	
	public UsuarioResponse(Usuario usuario) {
		this.idUsuario = usuario.getIdUsuario();
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.perfil = usuario.getPerfil();
	}
}