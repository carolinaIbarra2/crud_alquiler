package com.crud_alquiler.domain.reserva.entidades.dto;


import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;


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

        @NotNull
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
        @FutureOrPresent(message = "La fecha debe ser igual o mayor a la fecha actual")
        LocalDateTime fechaReserva,

        @NotNull
        @PositiveOrZero
        double costoReserva,

        @PositiveOrZero
        double penalidad

) {
}
