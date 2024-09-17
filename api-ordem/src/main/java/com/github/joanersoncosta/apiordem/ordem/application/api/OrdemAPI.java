package com.github.joanersoncosta.apiordem.ordem.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.joanersoncosta.apiordem.handler.ErrorApiResponse;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.AtualizaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.request.NovaOrdemRequest;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.NovaOrdemReIdsponse;
import com.github.joanersoncosta.apiordem.ordem.application.api.response.OrdemResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = "OrdemAPI", description = "Controle responsavel pelas ordens de serviço.")
@RestController
@RequestMapping("/v1/ordem")
public interface OrdemAPI {

	@Operation(summary = "Cria nova Ordem")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Ordem criada"),
			@ApiResponse(responseCode = "400", description = "Bad Request",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))
	})
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping
	NovaOrdemReIdsponse criaNovaOrdem(@RequestBody @Valid NovaOrdemRequest NovaOrdemRequest);

	@Operation(summary = "Atualiza Ordem por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "400", description = "Bad Request",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))
	})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@PutMapping(path = "/{idOrdem}")
	void atualizaOrdem(@PathVariable(name = "idOrdem") UUID idOrdem, @RequestBody @Valid AtualizaOrdemRequest rdemRequest);

	@Operation(summary = "Busca ordem por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna Ordem"),
			@ApiResponse(responseCode = "400", description = "Bad Request",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(path = "/{idOrdem}")
	OrdemResponse buscaOrdemPorId(@PathVariable(name = "idOrdem") UUID idOrdem);

	@Operation(summary = "Lista ordens")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Retorna Ordem"),
			@ApiResponse(responseCode = "400", description = "Bad Request",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))
	})
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping()
	List<OrdemResponse>listaOrdens();

	@Operation(summary = "Deleta Ordem")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "400", description = "Bad Request",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "404", description = "Not found",
			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class))),
			@ApiResponse(responseCode = "500", description = "Internal server error",
				content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorApiResponse.class)))
	})
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "/{idOrdem}")
	void deletaOrdemPorId(@PathVariable(name = "idOrdem") UUID idOrdem);

}