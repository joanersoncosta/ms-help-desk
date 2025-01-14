package com.github.joanersoncosta.apiusuario.usuario.application.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

public interface UsuarioRepository {
	Usuario salva(Usuario usuario);
	Optional<Usuario> buscaUsuarioPorId(UUID idUsuario);
	List<Usuario> buscaTodosOsUsuarios();
	void validaDadosDoUsuario(UUID idUsuario, String email);
}
