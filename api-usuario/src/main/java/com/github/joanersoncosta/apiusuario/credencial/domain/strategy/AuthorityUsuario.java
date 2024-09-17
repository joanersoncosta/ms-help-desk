package com.github.joanersoncosta.apiusuario.credencial.domain.strategy;

import java.util.Map;

public class AuthorityUsuario {
	private static final Map<String, AuthoritiesStrategy> strategies = Map.of("ADMIN", new AdminAuthoritiesStrategy(),
			"TECNICO", new TecnicoAuthoritiesStrategy(), "COMUM", new ComumAuthoritiesStrategy());

//	public static Collection<? extends GrantedAuthority> getAuthorities(String perfil) {
//		Collection<? extends GrantedAuthority> authorities = strategies.get(perfil).getAuthorities();
//		return authorities;
//	}
}
