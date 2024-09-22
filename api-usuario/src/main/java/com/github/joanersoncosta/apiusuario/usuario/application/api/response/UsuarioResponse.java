package com.github.joanersoncosta.apiusuario.usuario.application.api.response;

import java.util.UUID;

public record UsuarioResponse(
	UUID idUsuario,
	String nome,
	String email
	) {
}