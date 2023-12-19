package com.crud_alquiler.domain.costo_alquiler.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CostoAlquilerInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @NotNull
        double costoDia,
        @NotNull
        LocalDateTime fechaInicial,
        @NotNull
        LocalDateTime fechaFinal
) {
}
