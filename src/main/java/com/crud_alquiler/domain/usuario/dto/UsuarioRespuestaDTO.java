package com.crud_alquiler.domain.usuario.dto;

import com.crud_alquiler.domain.usuario.Rol;
import com.crud_alquiler.domain.usuario.Usuario;

public record UsuarioRespuestaDTO(

        Long id,
        String nombre,
        String apellido_paterno,
        String apellido_materno,
        String cedula,
        String login,
        String contrasenia,
        Rol rol

) {

    public UsuarioRespuestaDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getApellido_paterno(),
                usuario.getApellido_materno(),
                usuario.getCedula(),
                usuario.getLogin(),
                usuario.getContrasenia(),
                usuario.getRol());
    }
}
