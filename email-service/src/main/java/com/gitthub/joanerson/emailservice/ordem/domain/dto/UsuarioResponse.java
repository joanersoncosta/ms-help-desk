package com.gitthub.joanerson.emailservice.ordem.domain.dto;

import java.util.UUID;

public record UsuarioResponse(
        UUID idUsuario,
        String nome,
        String email
){}