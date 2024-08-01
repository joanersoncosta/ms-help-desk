package com.github.joanersoncosta.apiusuario.credencial.strategy;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class TecnicoAuthoritiesStrategy implements AuthoritiesStrategy {
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_TECNICO"), new SimpleGrantedAuthority("ROLE_COMUM"));
	}
}