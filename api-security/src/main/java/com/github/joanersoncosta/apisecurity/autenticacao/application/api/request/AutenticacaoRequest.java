package com.github.joanersoncosta.apisecurity.autenticacao.application.api.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AutenticacaoRequest {
	@NotBlank(message = "O cliente não pode estar em branco!")
	@Email
	@Schema(description = "Este é o E-mail do úsuario", example = "maria@gmail.com")
	private String usuario;
	@NotBlank
	@Schema(description = "Esta é a senha do úsuario", example = "123456")
	private String senha;

	public UsernamePasswordAuthenticationToken getUserPassToken() {
		return new UsernamePasswordAuthenticationToken(usuario, senha);
	}
}