package com.github.joanersoncosta.apisecurity.credencial.domain;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;

@Getter
@Document(collection = "Credencial")
public class Credencial {
	private UUID idCredencial;
	private String usuario;
	private String senha;
	private Perfil perfil;
	private boolean validado;
}