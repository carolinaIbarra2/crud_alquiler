package com.crud_alquiler.servicio.usuario;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioRespuestaDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import com.crud_alquiler.domain.usuario.repository.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *Implementación de UsuarioServiceRepository que gestiona la lógica de negocio relacionada con los
 *usuarios.
 */
@Service
public class UsuarioService implements UsuarioServiceInterface {

    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor para inicializar las dependencias
     * @param usuarioRepository Repositorio para operaciones relacionadas con Usuario
     */
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioRespuestaDTO getUsuario(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        return new UsuarioRespuestaDTO(usuario);
    }

    @Override
    public Page<UsuarioRespuestaDTO> findByUsuario(Pageable pageable){
        return usuarioRepository.findAll(pageable).map(UsuarioRespuestaDTO::new);
    }

    @Override
    public UsuarioRespuestaDTO insertUsuario(UsuarioInsertDTO usuarioInsertDTO){
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioInsertDTO));
        return new UsuarioRespuestaDTO((usuario));
    }

    @Override
    public UsuarioRespuestaDTO updateUsuario(UsuarioUpdateDTO usuarioUpdateDTO){
        Usuario usuario = usuarioRepository.getReferenceById(usuarioUpdateDTO.id());
        usuario.updateUsuario(usuarioUpdateDTO);
        return new UsuarioRespuestaDTO(usuario);
    }

    @Override
    public void delectUsuario(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.deleteById(usuario.getId());
    }

}
