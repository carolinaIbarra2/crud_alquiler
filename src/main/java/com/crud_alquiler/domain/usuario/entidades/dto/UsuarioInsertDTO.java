package com.crud_alquiler.domain.usuario.entidades.dto;

import com.crud_alquiler.domain.usuario.entidades.Rol;
import jakarta.persistence.Column;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;

/**
 * Esta clase se utiliza para representar datos inmutables relacionados con la inserccion de datos de un
 *usuario
 */

public record UsuarioInsertDTO(

        @NotBlank
        @Size(min = 2, max = 50)
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        String nombre,
        @NotBlank
        @Size(min=2, max = 50)
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        String apellidoPaterno,
        @NotBlank
        @Pattern(regexp = "[a-zA-Z]+", message = "Este campo solo acepta letras")
        @Size(min = 2, max = 50)
        String apellidoMaterno,

        @NotBlank
        @Size(max = 15)
        @Column(unique = true)
        @Pattern(regexp = "^[0-9]+$", message = "El campo debe contener solo números")
        String cedula,

        @NotBlank
        @Size(min = 2, max = 50 )
        @Column(unique = true)
        String login,

        @NotBlank
        @Size(min = 8, max = 50 )
        String contrasenia,

        @NotNull
        Rol rol
) {


}
