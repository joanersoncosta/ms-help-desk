package com.github.joanersoncosta.hdcommonslib.usuario.domain.response;

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