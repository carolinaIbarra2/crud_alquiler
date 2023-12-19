package com.crud_alquiler.domain.reserva.dto;

import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoRespuestaDTO;
import com.crud_alquiler.domain.reserva.Reserva;
import com.crud_alquiler.domain.usuario.dto.UsuarioRespuestaDTO;

import java.time.LocalDateTime;

public record ReservaRespuestaDTO(

        Long id,
        EspacioFisicoRespuestaDTO espacioFisico,
        UsuarioRespuestaDTO usuario,
        LocalDateTime fecha_reserva,
        double costo_reserva,
        double penalidad

) {
    public ReservaRespuestaDTO(Reserva reserva){
        this(
                reserva.getId(),
                new EspacioFisicoRespuestaDTO(reserva.getEspacioFisico()),
                new UsuarioRespuestaDTO(reserva.getUsuario()),
                reserva.getFecha_reserva(),
                reserva.getCosto_reserva(),
                reserva.getPenalidad()
        );
    }
}
