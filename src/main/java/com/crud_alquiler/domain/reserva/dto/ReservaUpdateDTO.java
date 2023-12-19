package com.crud_alquiler.domain.reserva.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservaUpdateDTO(

        Long id,
        Long espacioFisicoId,
        Long usuarioId,
        LocalDateTime fechaReserva,
        @DecimalMin(value = "0.0")
        double costoReserva,
        double penalidad

) {
}
