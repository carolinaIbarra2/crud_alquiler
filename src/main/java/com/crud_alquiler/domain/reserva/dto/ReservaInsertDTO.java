package com.crud_alquiler.domain.reserva.dto;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;

public record ReservaInsertDTO(

        @NotNull
        Long espacioFisicoId,
        @NotNull
        Long usuarioId,
        LocalDateTime fecha_reserva,
        @DecimalMin(value = "0.0")
        @NotNull
        double costo_reserva,

        double penalidad

) {
}
