package com.github.joanersoncosta.apisecurity.credencial.domain.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.With;

@With
public record UsuarioNovoRequest(
		@Schema(description = "Este é o nome do úsuario", example = "Maria Santos")
		@NotBlank(message = "Campo nome não pode estar em branco.")
		String nome,
		@Schema(description = "Este é o email do úsuario", example = "maria@gmail.com")
		@NotBlank(message = "Campo email não pode estar em branco.")
		@Email(message = "Email invalido, digite novamente.")
		@Size(min = 6, max = 40, message = "O email deve ter entre 6 e 40 caracteres.")
		String email,
		@Schema(description = "Esta é a senha do úsuario", example = "123456")
		@NotBlank(message = "Campo senha não pode estar em branco.")
		@Size(min = 4, max = 6, message = "A senha deve ter entre 4 e 6 dígitos.")
		String senha,
		@Schema(description = "Este são os perfis do úsuario", example = "[\"ADMIN\", \"COMUM\"], , \"TECNICO\"]")
		String perfil) implements Serializable{
	private static final long serialVersionUID = 1L;
}