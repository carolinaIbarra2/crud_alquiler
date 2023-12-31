package com.crud_alquiler.domain.tipo_espacio.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para actualizar información relacionada con un tipo de espacio
 */
public record TipoEspacioUpdateDTO(

        @NotNull
        Long id,
        @Size(min = 5, max = 100)
        @Pattern(regexp = "^[a-zA-Z ]+$", message = "Este campo solo acepta letras")
        String tipoEspacio
) {
}
