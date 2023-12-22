package com.crud_alquiler.domain.reserva.entidades.dto;

import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.reserva.entidades.Reserva;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioRespuestaDTO;

import java.time.LocalDateTime;

/**
 * Esta clase representa datos de respuesta relacionados con una reserva
 */
public record ReservaRespuestaDTO(

        Long id,
        EspacioFisicoRespuestaDTO espacioFisico,
        UsuarioRespuestaDTO usuario,
        LocalDateTime fechaReserva,

        double costoReserva,

        double penalidad

) {
    public ReservaRespuestaDTO(Reserva reserva){
        this(
                reserva.getId(),
                new EspacioFisicoRespuestaDTO(reserva.getEspacioFisico()),
                new UsuarioRespuestaDTO(reserva.getUsuario()),
                reserva.getFechaReserva(),
                reserva.getCostoReserva(),
                reserva.getPenalidad()
        );
    }
}
