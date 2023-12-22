package com.crud_alquiler.domain.reserva.entidades.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

/**
 * Esta clase se utiliza para actualizar información relacionada con una reserva
 */
public record ReservaUpdateDTO(

        Long id,
        Long espacioFisicoId,
        Long usuarioId,
        LocalDateTime fechaReserva,
        double costoReserva,
        double penalidad

) {
}
