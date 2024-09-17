package com.github.joanersoncosta.hdcommonslib.usuario.domain.request;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.With;

@With
public record AtualizaUsuarioRequest(
		@Schema(description = "Este é o nome do úsuario", example = "Maria Santos")
		String nome,
		@Schema(description = "Este é o email do úsuario", example = "maria@gmail.com")
		@Email(message = "Email invalido, digite novamente.")
		@Size(min = 6, max = 40, message = "O email deve ter entre 6 e 40 caracteres.")
		String email,
		@Schema(description = "Este são os perfis do úsuario", example = "[\"ADMIN\", \"COMUM\"], , \"TECNICO\"]")
		String perfil) implements Serializable{
	private static final long serialVersionUID = 1L;
}