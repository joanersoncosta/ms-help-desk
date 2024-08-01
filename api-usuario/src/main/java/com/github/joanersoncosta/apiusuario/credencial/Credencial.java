package com.github.joanersoncosta.apiusuario.credencial;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.joanersoncosta.hdcommonslib.handler.APIException;

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
public class Credencial implements UserDetails {

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

	public Credencial(String usuario, String senha, Perfil perfil) {
		this.idCredencial = UUID.randomUUID();
		this.usuario = usuario;
		this.senha = senha;
		this.perfil = perfil;
		this.validado = true;
	}

	public void validaCredencial() {
		this.validado = true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (perfil.getNome().equals("ADMIN")) {
			return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_TECNICO"),
					new SimpleGrantedAuthority("ROLE_COMUM"));
		} else if (perfil.getNome().equals("TECNICO")) {
			return List.of(new SimpleGrantedAuthority("ROLE_COMUM"), new SimpleGrantedAuthority("ROLE_TECNICO"));
		} else {
			return List.of(new SimpleGrantedAuthority("ROLE_COMUM"));
		}
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private static final long serialVersionUID = 1L;

	public void validaAcessoAdmin() {
		if (!perfil.getNome().equals("ADMIN")) {
			throw APIException.build(HttpStatus.FORBIDDEN, "Acesso negado");
		}
	}
}
