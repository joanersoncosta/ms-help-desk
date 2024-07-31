package com.github.joanersoncosta.apiusuario.usuario.application.api.request;

import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;

import com.github.joanersoncosta.hdcommonslib.usuario.enuns.PerfilUsuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UsuarioNovoRequest(
		@NotBlank(message = "Campo nome não pode estar em branco.")
		String nome,
		@NotBlank(message = "Campo email não pode estar em branco.")
		@Indexed(unique = true)
		@Email(message = "Email invalido, digite novamento.")
		String email,
		@NotBlank(message = "Campo senha não pode estar em branco.")
		@Size(min = 4, max = 6, message = "A senha deve ter entre 4 e 6 dígitos.")
		String senha,
		@NotEmpty(message = "O Usuario deve ter pelo menos um perfil")
		Set<PerfilUsuario> perfil
		) {
}