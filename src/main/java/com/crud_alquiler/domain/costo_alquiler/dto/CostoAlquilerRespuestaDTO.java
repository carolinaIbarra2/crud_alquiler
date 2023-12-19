package com.crud_alquiler.domain.costo_alquiler.dto;

import com.crud_alquiler.domain.costo_alquiler.CostoAlquiler;
import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoRespuestaDTO;

import java.time.LocalDateTime;

public record CostoAlquilerRespuestaDTO(

        Long id,
        EspacioFisicoRespuestaDTO espacioFisico,
        double costo_dia,
        LocalDateTime fecha_inicial,
        LocalDateTime fecha_final
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
