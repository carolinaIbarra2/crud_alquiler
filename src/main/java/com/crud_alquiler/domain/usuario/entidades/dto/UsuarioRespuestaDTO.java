package com.crud_alquiler.domain.usuario.entidades.dto;

import com.crud_alquiler.domain.usuario.entidades.Rol;
import com.crud_alquiler.domain.usuario.entidades.Usuario;

/**
 * Esta clase representa datos de respuesta relacionados con un usuario
 */
public record UsuarioRespuestaDTO(

        Long id,
        String nombre,
        String apellidoPaterno,
        String apellidoMaterno,
        String cedula,
        String login,
        String contrasenia,
        Rol rol

) {

    public UsuarioRespuestaDTO(Usuario usuario){
        this(usuario.getId(),
                usuario.getNombre(),
                usuario.getApellidoPaterno(),
                usuario.getApellidoMaterno(),
                usuario.getCedula(),
                usuario.getLogin(),
                usuario.getContrasenia(),
                usuario.getRol());
    }
}
