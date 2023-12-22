package com.crud_alquiler.domain.costo_alquiler.entidades.dto;

import com.crud_alquiler.domain.costo_alquiler.entidades.CostoAlquiler;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoRespuestaDTO;

import java.time.LocalDateTime;

/**
 * Esta clase representa datos de respuesta relacionados con un costo de alquiler
 */
public record CostoAlquilerRespuestaDTO(

        Long id,
        EspacioFisicoRespuestaDTO espacioFisico,
        double costoDia,
        LocalDateTime fechaInicial,
        LocalDateTime fechaFinal
) {
    public CostoAlquilerRespuestaDTO(CostoAlquiler costoAlquiler){
        this(
                costoAlquiler.getId(),
                new EspacioFisicoRespuestaDTO(costoAlquiler.getEspacioFisico()),
                costoAlquiler.getCostoDia(),
                costoAlquiler.getFechaInicial(),
                costoAlquiler.getFechaFinal()
        );
    }
}
