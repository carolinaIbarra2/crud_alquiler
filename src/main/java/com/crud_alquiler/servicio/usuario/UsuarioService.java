package com.crud_alquiler.servicio.usuario;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioRespuestaDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import com.crud_alquiler.domain.usuario.repository.UsuarioRepository;
import com.crud_alquiler.domain.usuario.validation.UsuarioValidationInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *Implementación de UsuarioServiceRepository que gestiona la lógica de negocio relacionada con los
 *usuarios.
 */
@Service
public class UsuarioService implements UsuarioServiceInterface, UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final List<UsuarioValidationInterface> usuarioValidationInterface;


    /**
     * Constructor para inicializar las dependencias
     * @param usuarioRepository  Repositorio para operaciones relacionadas con Usuario
     * @param usuarioValidationInterface lógica de validación para la inserción y actualización de Usuario.
     */
    public UsuarioService(UsuarioRepository usuarioRepository, List<UsuarioValidationInterface> usuarioValidationInterface) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioValidationInterface = usuarioValidationInterface;
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
        usuarioValidationInterface.forEach(v->v.validationInsert(usuarioInsertDTO));
        Usuario usuario = usuarioRepository.save(new Usuario(usuarioInsertDTO));
        return new UsuarioRespuestaDTO((usuario));
    }



    @Override
    public UsuarioRespuestaDTO updateUsuario(UsuarioUpdateDTO usuarioUpdateDTO){
        usuarioValidationInterface.forEach(v->v.validationUpdate(usuarioUpdateDTO));
        Usuario usuario = usuarioRepository.getReferenceById(usuarioUpdateDTO.id());
        usuario.updateUsuario(usuarioUpdateDTO);
        return new UsuarioRespuestaDTO(usuario);
    }

    @Override
    public void delectUsuario(Long id){
        Usuario usuario = usuarioRepository.getReferenceById(id);
        usuarioRepository.deleteById(usuario.getId());
    }

    @Override
    public UserDetails findByLogin(String login) {
        return usuarioRepository.findByLogin(login);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }
}
