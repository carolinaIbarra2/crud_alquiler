package com.crud_alquiler.domain.costo_alquiler.entidades.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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
        @NotNull(message = "Debe ingresar una fecha inicial")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @FutureOrPresent(message = "La fecha debe ser igual o mayor a la fecha actual")
        LocalDateTime fechaInicial,
        @NotNull(message = "Debe ingresar una fecha final")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @FutureOrPresent(message = "La fecha debe ser igual o mayor a la fecha actual")
        LocalDateTime fechaFinal
) {
}
