package com.crud_alquiler.domain.usuario.entidades.dto;

import com.crud_alquiler.domain.usuario.entidades.Rol;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para actualizar información relacionada con un usuario
 */
public record UsuarioUpdateDTO(

        @NotNull
        Long id,
        //@NotBlank
        @Size(min = 2, max = 50)
        String nombre,
        //@NotBlank
        @Size(min=2, max = 50)
        String apellidoPaterno,
        //@NotBlank
        @Size(min = 2, max = 50)
        String apellidoMaterno,

        //@NotBlank
        @Size(max = 15)
        @Column(unique = true)
        String cedula,

        //@NotBlank
        @Size(max = 50 )
        @Column(unique = true)
        String login,

        //@NotBlank
        @Size(max = 50 )
        String contrasenia,

        //@NotNull
        Rol rol
) {
}
