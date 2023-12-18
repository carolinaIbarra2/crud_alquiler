package com.crud_alquiler.domain.espacio_fisico.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

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