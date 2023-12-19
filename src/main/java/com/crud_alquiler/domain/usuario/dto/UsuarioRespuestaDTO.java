package com.crud_alquiler.domain.usuario.dto;

import com.crud_alquiler.domain.usuario.Rol;
import com.crud_alquiler.domain.usuario.Usuario;

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
