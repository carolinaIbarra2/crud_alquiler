package com.crud_alquiler.domain.costo_alquiler.entidades.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Esta clase se utiliza para actualizar información relacionada con un costo alquiler
 */
public record CostoAlquilerUpdateDTO(

        Long id,
        Long espacioFisicoId,
        @DecimalMin(value = "0.0")
        @NotNull
        double costoDia,
        @NotNull
        LocalDateTime fechaInicial,
        @NotNull
        LocalDateTime fechaFinal
) {
}
