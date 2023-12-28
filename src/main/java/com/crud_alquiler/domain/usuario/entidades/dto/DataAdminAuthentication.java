package com.crud_alquiler.domain.usuario.entidades.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataAdminAuthentication(
        @NotBlank
        String login,
        @NotBlank
        String contrasenia) {
}
