package com.github.joanersoncosta.apisecurity.security.enuns;

import lombok.Getter;

@Getter
public enum AuthUrlMapping {

	PERMIT_ALL(null, new String[] {
	            "/public/**",
	            "/v1/usuario/**",
	});

    private final String role;
    private final String[] urls;

    AuthUrlMapping(String role, String[] urls) {
        this.role = role;
        this.urls = urls;
    }
}
