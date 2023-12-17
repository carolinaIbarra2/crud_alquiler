package com.crud_alquiler.domain.tipo_espacio.dto;

import com.crud_alquiler.domain.tipo_espacio.TipoEspacio;

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
