package com.github.joanersoncosta.apiusuario.credencial.domain;

import lombok.With;

@With
public record CredencialRequest(String usuario, String senha, Perfil perfil) {

}