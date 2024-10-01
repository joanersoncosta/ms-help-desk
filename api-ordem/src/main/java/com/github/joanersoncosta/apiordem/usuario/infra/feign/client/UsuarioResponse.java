package com.github.joanersoncosta.apiordem.usuario.infra.feign.client;

import java.util.UUID;

public record UsuarioResponse(
	UUID idUsuario,
	String nome,
	String email
	){
}