package com.crud_alquiler.domain.espacio_fisico.dto;

import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioRespuestaDTO;

public record EspacioFisicoRespuestaDTO(
        Long id,
        TipoEspacioRespuestaDTO tipoEspacio,
        String nombre,
        int capacidad,
        String descripcion) {

    public EspacioFisicoRespuestaDTO(EspacioFisico espacioFisico){
        this(
                espacioFisico.getId(),
                new TipoEspacioRespuestaDTO(espacioFisico.getTipoEspacio()),
                espacioFisico.getNombre(),
                espacioFisico.getCapacidad(),
                espacioFisico.getDescripcion()
        );
    }
}
