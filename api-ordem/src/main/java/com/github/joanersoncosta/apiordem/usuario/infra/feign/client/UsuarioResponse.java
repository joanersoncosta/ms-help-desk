package com.github.joanersoncosta.apiordem.usuario.infra.feign.client;

import java.io.Serializable;
import java.util.UUID;

public record UsuarioResponse(
	UUID idUsuario,
	String nome,
	String email
	) implements Serializable{
	private static final long serialVersionUID = 1L;
}