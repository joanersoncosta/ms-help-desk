package com.github.joanersoncosta.apiusuario.usuario.application.api.response;

import java.io.Serializable;
import java.util.UUID;

public record UsuarioResponse(
	UUID idUsuario,
	String nome,
	String email,
	String perfil
	) implements Serializable{
	private static final long serialVersionUID = 1L;
}