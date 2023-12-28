package com.crud_alquiler.domain.tipo_espacio.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de un
 * tipo de espacio
 */
public record TipoEspacioInsertDTO(

        @NotBlank
        @Size(min = 5, max = 100)
        @Pattern(regexp = "^[a-zA-Z ]+$", message = "Este campo solo acepta letras")
        String tipoEspacio

) {
}
