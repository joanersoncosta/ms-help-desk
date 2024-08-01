package com.github.joanersoncosta.apisecurity.credencial.domain;

import com.github.joanersoncosta.hdcommonslib.usuario.domain.request.UsuarioNovoRequest;

import lombok.With;

@With
public record CredencialRequest(UsuarioNovoRequest usuarioRequest) {

}