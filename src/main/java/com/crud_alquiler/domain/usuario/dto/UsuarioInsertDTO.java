package com.crud_alquiler.domain.usuario.dto;

import com.crud_alquiler.domain.usuario.Rol;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UsuarioInsertDTO(

        @NotBlank
        @Size(min = 2, max = 50)
        String nombre,
        @NotBlank
        @Size(min=2, max = 50)
        String apellido_paterno,
        @NotBlank
        @Size(min = 2, max = 50)
        String apellido_materno,

        @NotBlank
        @Size(max = 15)
        @Column(unique = true)
        String cedula,

        @NotBlank
        @Size(max = 50 )
        @Column(unique = true)
        String login,

        @NotBlank
        @Size(max = 50 )
        String contrasenia,

        @NotNull
        Rol rol
) {
}
