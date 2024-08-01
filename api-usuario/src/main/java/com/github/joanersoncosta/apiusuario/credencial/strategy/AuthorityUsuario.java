package com.github.joanersoncosta.apiusuario.credencial.strategy;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;

public class AuthorityUsuario {
	private static final Map<String, AuthoritiesStrategy> strategies = Map.of("ADMIN", new AdminAuthoritiesStrategy(),
			"TECNICO", new TecnicoAuthoritiesStrategy(), "COMUM", new ComumAuthoritiesStrategy());

	public static Collection<? extends GrantedAuthority> getAuthorities(String perfil) {
		Collection<? extends GrantedAuthority> authorities = strategies.get(perfil).getAuthorities();
		return authorities;
	}
}
