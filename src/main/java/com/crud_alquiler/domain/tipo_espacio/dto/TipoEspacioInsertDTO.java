package com.crud_alquiler.domain.tipo_espacio.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TipoEspacioInsertDTO(

        @NotBlank
        @Size(min = 5, max = 100)
        String tipoEspacio

) {
}
