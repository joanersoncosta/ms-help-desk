package com.github.joanersoncosta.apiusuario.credencial.domain.strategy;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface AuthoritiesStrategy {
    Collection<? extends GrantedAuthority> getAuthorities();
}