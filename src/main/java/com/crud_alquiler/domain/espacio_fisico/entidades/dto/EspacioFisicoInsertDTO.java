package com.crud_alquiler.domain.espacio_fisico.entidades.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de un
 * espacio fisico
 */
public record EspacioFisicoInsertDTO(
        @NotNull
        Long tipoEspacioId,

        @NotBlank
        @Size(min = 3, max = 100)
        String nombre,

        @PositiveOrZero
        @NotNull
        int capacidad,

        @Size(min = 3, max = 200)
        String descripcion


) {}
