package com.crud_alquiler.domain.espacio_fisico.entidades.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para actualizar información relacionada con un espacio fisico
 */
public record EspacioFisicoUpdateDTO(

        Long id,

        Long tipoEspacioId,

        @Size(min = 3, max = 100)
        String nombre,

        @PositiveOrZero
        int capacidad,

        @Size(min = 3, max = 200)
        String descripcion


) {}