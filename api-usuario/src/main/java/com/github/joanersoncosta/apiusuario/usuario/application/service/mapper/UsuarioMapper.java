package com.github.joanersoncosta.apiusuario.usuario.application.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.AtualizaUsuarioRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioResponse;
import com.github.joanersoncosta.apiusuario.usuario.domain.Usuario;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UsuarioMapper {
	UsuarioResponse converteUsuarioResponse(final Usuario usuario);
	@Mapping(target = "idUsuario", ignore = true)
	Usuario converteUsuarioRequest(final UsuarioNovoRequest usuario);

	@Mapping(target = "idUsuario", ignore = true)
	Usuario atualizaUsuario(final AtualizaUsuarioRequest usuarioRequest, @MappingTarget Usuario usuario);
}