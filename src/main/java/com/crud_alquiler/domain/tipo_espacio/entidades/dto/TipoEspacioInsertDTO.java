package com.crud_alquiler.domain.tipo_espacio.entidades.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de un
 * tipo de espacio
 */
public record TipoEspacioInsertDTO(

        @NotBlank
        @Size(min = 5, max = 100)
        String tipoEspacio

) {
}
