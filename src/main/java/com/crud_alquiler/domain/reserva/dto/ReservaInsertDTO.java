package com.crud_alquiler.domain.reserva.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public record ReservaInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @NotNull
        Long usuarioId,
        LocalDateTime fechaReserva,
        @DecimalMin(value = "0.0")
        @NotNull
        double costoReserva,

        double penalidad

) {
}
