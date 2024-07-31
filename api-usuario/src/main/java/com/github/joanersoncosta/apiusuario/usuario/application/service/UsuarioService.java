package com.github.joanersoncosta.apiusuario.usuario.application.service;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;

public interface UsuarioService {
	UsuarioResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest);
}
