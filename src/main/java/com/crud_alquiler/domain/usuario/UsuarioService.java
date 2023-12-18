package com.crud_alquiler.domain.usuario;

import com.crud_alquiler.domain.usuario.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.dto.UsuarioRespuestaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service /*representa la lógica de negocio de la aplicación. Por lo general, estas clases contienen
la lógica que no está relacionada directamente con la persistencia de datos */
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    /* este método recupera un usuario utilizando su id, desde una base de datos a través de usuarioRepository,
     y luego lo convierte en un UsuarioRespuestaDTO para devolverlo como respuesta.*/
    public UsuarioRespuestaDTO getUsuario(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return new UsuarioRespuestaDTO(usuario);
    }

    //Este metodo lista
    public Page<UsuarioRespuestaDTO> findByUsuario(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioRespuestaDTO::new);
    }

    /*este método recibe datos de un nuevo usuario, los utiliza para crear un objeto Usuario, lo guarda en
    un repositorio usando usuarioRepository.save, y luego devuelve una representación resumida o modificada
    de este usuario como un UsuarioRespuestaDTO. */
    public UsuarioRespuestaDTO insertUsuario(UsuarioInsertDTO usuarioInsertDTO){
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioInsertDTO));
        return new UsuarioRespuestaDTO((usuario));
    }

}
