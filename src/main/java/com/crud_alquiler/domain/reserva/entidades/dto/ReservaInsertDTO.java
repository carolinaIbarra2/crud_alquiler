package com.crud_alquiler.domain.reserva.entidades.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de una
 * reserva
 */
public record ReservaInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @NotNull
        Long usuarioId,
        LocalDateTime fechaReserva,

        @NotBlank
        double costoReserva,
        double penalidad

) {
}
