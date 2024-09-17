package com.github.joanersoncosta.apiusuario.usuario.application.service;

import java.util.List;
import java.util.UUID;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.AtualizaUsuarioRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;

public interface UsuarioService {
	UsuarioNovoResponse criaNovoUsuario(UsuarioNovoRequest usuarioRequest);
	UsuarioResponse buscaUsuarioPorId(UUID idUsuario);
	List<UsuarioResponse> buscaTodosOsUsuarios();
	UsuarioResponse atualizaDadosDoUsuario(UUID idUsuario, AtualizaUsuarioRequest usuarioRequest);
}
