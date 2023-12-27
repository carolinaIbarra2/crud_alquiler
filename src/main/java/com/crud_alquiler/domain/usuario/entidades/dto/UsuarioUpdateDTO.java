package com.crud_alquiler.domain.usuario.entidades.dto;

import com.crud_alquiler.domain.usuario.entidades.Rol;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * Esta clase se utiliza para actualizar información relacionada con un usuario
 */
public record UsuarioUpdateDTO(

        @NotNull
        Long id,

        @Size(min = 2, max = 50)
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        String nombre,

        @Size(min=2, max = 50)
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        String apellidoPaterno,


        @Size(min = 2, max = 50)
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        String apellidoMaterno,

        @Size(max = 15)
        @Column(unique = true)
        @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números")
        String cedula,

        //@NotBlank
        @Size(max = 50 )
        @Column(unique = true)
        String login,

        //@NotBlank
        @Size(min = 8, max = 50 )
        String contrasenia,

        //@NotNull
        Rol rol
) {
}
