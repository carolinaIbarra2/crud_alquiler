package com.crud_alquiler.domain.usuario.entidades;

import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.entidades.dto.UsuarioUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Collection;
import java.util.List;

/**
 * Representa la entidad Usuario que almacena la información relacionada con el usuario.
 */
@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nombre;
    @Column(name ="apellido_paterno")
    String apellidoPaterno;
    @Column(name = "apellido_materno")
    String apellidoMaterno;
    String cedula;
    String login;
    String contrasenia;

   @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    Rol rol;

    /**
     * Constructor que inicializa un objeto Usuario a partir de un objeto UsuarioInsertDTO
     * @param usuarioInsertDTO El DTO con la información para la creación de un usuario.
     */
   public Usuario(UsuarioInsertDTO usuarioInsertDTO){
       this.nombre = usuarioInsertDTO.nombre();
       this.apellidoPaterno =usuarioInsertDTO.apellidoPaterno();
       this.apellidoMaterno = usuarioInsertDTO.apellidoMaterno();;
       this.cedula = usuarioInsertDTO.cedula();
       this.login = usuarioInsertDTO.login();
       this.contrasenia = hashPassword(usuarioInsertDTO.contrasenia());;
       this.rol = usuarioInsertDTO.rol();
   }



    /**
     * Método que actualiza los datos de un objeto Usuario con la información proporcionada en un DTO de
     * actualización.
     * @param usuarioUpdateDTO El DTO con la información actualizada para el usuario
     */
    public void updateUsuario(UsuarioUpdateDTO usuarioUpdateDTO){
       if (usuarioUpdateDTO.nombre() != null){
           this.nombre = usuarioUpdateDTO.nombre();
       }
       if (usuarioUpdateDTO.apellidoPaterno() != null){
           this.apellidoPaterno = usuarioUpdateDTO.apellidoPaterno();
       }
       if (usuarioUpdateDTO.apellidoMaterno() != null){
           this.apellidoMaterno = usuarioUpdateDTO.apellidoMaterno();
       }
       if (usuarioUpdateDTO.cedula() != null){
           this.cedula = usuarioUpdateDTO.cedula();
       }
       if (usuarioUpdateDTO.login() != null){
           this.login = usuarioUpdateDTO.login();
       }
       if (usuarioUpdateDTO.contrasenia() != null){
           this.contrasenia = usuarioUpdateDTO.contrasenia();
       }
       if (usuarioUpdateDTO.rol() != null){
           this.rol = usuarioUpdateDTO.rol();
       }
    }

    private static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(10);
        return BCrypt.hashpw(password_plaintext, salt);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return contrasenia;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
