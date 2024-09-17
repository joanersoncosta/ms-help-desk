package com.github.joanersoncosta.apisecurity.credencial.domain.strategy;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AdminAuthoritiesStrategy implements AuthoritiesStrategy {
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_TECNICO"),
				new SimpleGrantedAuthority("ROLE_COMUM"));
	}
}