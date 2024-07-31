package com.github.joanersoncosta.apiusuario.usuario.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiusuario.usuario.application.api.request.UsuarioNovoRequest;
import com.github.joanersoncosta.apiusuario.usuario.application.api.response.UsuarioNovoResponse;
import com.github.joanersoncosta.hdcommonslib.handler.APIException;
import com.github.joanersoncosta.hdcommonslib.usuario.domain.response.UsuarioResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "UsuarioAPI", description = "Controle responsavel pelas oprações do úsuario.")
@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {
	
	@Operation(summary = "Cria novo úsuario")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Úsuario criado"),
			@ApiResponse(responseCode = "400", description = "Úsuario já cadastrado",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIException.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIException.class)))
	})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	UsuarioNovoResponse criaNovoUsuario(@RequestBody @Valid UsuarioNovoRequest usuarioRequest);

	@Operation(summary = "Busca úsuario por id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Úsuario encontrado"),
			@ApiResponse(responseCode = "204", description = "Úsuario não encontrado",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIException.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = APIException.class)))
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value  = "/{idUsuario}")
	UsuarioResponse buscaUsuarioPorId(
			@Parameter(description = "Id usuario", required = true, example = "b700b45a-d1ee-41da-95bd-6d477a7c862")
			@PathVariable(value  = "idUsuario") UUID idUsuario);
}