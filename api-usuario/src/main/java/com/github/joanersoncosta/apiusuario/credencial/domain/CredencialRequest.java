package com.github.joanersoncosta.apiusuario.credencial.domain;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;

import lombok.With;

@With
public record CredencialRequest(UsuarioNovoRequest usuarioRequest) {

}