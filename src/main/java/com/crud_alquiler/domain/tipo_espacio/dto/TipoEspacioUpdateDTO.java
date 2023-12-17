package com.crud_alquiler.domain.tipo_espacio.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TipoEspacioUpdateDTO(

        @NotNull
        Long id,
        @Size(min = 5, max = 100)
        String tipoEspacio
) {
}
