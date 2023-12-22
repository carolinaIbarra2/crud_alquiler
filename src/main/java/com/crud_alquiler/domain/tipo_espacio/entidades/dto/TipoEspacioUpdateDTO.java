package com.crud_alquiler.domain.tipo_espacio.entidades.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para actualizar información relacionada con un tipo de espacio
 */
public record TipoEspacioUpdateDTO(

        @NotNull
        Long id,
        @Size(min = 5, max = 100)
        String tipoEspacio
) {
}
