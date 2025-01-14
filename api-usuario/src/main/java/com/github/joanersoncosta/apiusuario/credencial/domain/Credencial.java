package com.github.joanersoncosta.apiusuario.credencial.domain;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Credencial")
public class Credencial {

	@Id
	@Getter
	private UUID idCredencial;
	@Getter
	@Indexed(unique = true)
	private String usuario;
	@NotNull
	@Size(max = 60)
	@Getter
	private String senha;

	@Getter
	private Perfil perfil;

	@Getter
	private boolean validado;

	public Credencial(String usuario, String senha, String perfil) {
		this.idCredencial = UUID.randomUUID();
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = new Perfil(perfil);
		this.validado = true;
	}

	public void validaCredencial() {
		this.validado = true;
	}
}