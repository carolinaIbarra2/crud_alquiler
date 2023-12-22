package com.crud_alquiler.domain.tipo_espacio.entity.dto;

import com.crud_alquiler.domain.tipo_espacio.entity.TipoEspacio;

/**
 * Esta clase representa datos de respuesta relacionados con un tipo de espacio
 */
public record TipoEspacioRespuestaDTO(
    Long id,
    String tipoEspacio
) {

    public TipoEspacioRespuestaDTO(TipoEspacio tipoEspacio){
        this(
                tipoEspacio.getId(),
                tipoEspacio.getTipoEspacio()
        );
    }

}
