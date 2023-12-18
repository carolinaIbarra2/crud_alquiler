package com.crud_alquiler.domain.costo_alquiler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CostoAlquilerInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @NotNull
        double costo_dia,
        @NotNull
        LocalDateTime fecha_inicial,
        @NotNull
        LocalDateTime fecha_final
) {
}
