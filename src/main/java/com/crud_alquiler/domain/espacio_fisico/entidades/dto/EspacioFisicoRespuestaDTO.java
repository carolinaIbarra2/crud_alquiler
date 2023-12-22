package com.crud_alquiler.domain.espacio_fisico.entidades.dto;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioRespuestaDTO;

/**
 * Esta clase representa datos de respuesta relacionados con un espacio fisico
 */
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
