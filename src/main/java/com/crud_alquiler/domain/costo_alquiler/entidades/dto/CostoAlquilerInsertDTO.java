package com.crud_alquiler.domain.costo_alquiler.entidades.dto;

import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de un
 * costo alquiler
 */
public record CostoAlquilerInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @DecimalMin(value = "0.0",message = "El costo por día no puede ser menor que 0.0")
        @NotNull
        double costoDia,
        @NotNull(message = "Debe ingresar una fecha inicial")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @FutureOrPresent(message = "La fecha debe ser igual o mayor a la fecha actual")
        LocalDateTime fechaInicial,
        @NotNull(message = "Debe ingresar una fecha inicial")
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @FutureOrPresent(message = "La fecha debe ser igual o mayor a la fecha actual")
        LocalDateTime fechaFinal
) {
}
