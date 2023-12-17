package com.crud_alquiler.domain.dto;

import com.crud_alquiler.domain.TipoEspacio;

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
