package com.crud_alquiler.domain.usuario;

import com.crud_alquiler.domain.usuario.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.dto.UsuarioUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

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
    private Rol rol;

   public Usuario(UsuarioInsertDTO usuarioInsertDTO){
       this.nombre = usuarioInsertDTO.nombre();
       this.apellidoPaterno =usuarioInsertDTO.apellidoPaterno();
       this.apellidoMaterno = usuarioInsertDTO.apellidoMaterno();;
       this.cedula = usuarioInsertDTO.cedula();
       this.login = usuarioInsertDTO.login();
       this.contrasenia = usuarioInsertDTO.contrasenia();;
       this.rol = usuarioInsertDTO.rol();
   }

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
   

}
