package com.github.joanersoncosta.apisecurity.autenticacao.application.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.github.joanersoncosta.apisecurity.autenticacao.domain.Token;

public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}