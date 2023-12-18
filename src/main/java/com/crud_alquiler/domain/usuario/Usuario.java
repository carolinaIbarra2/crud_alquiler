package com.crud_alquiler.domain.usuario;

import com.crud_alquiler.domain.usuario.dto.UsuarioInsertDTO;
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
    String apellido_paterno;
    String apellido_materno;
    String cedula;
    String login;
    String contrasenia;

   @Enumerated(EnumType.STRING)
    @Column(name = "rol")
    private Rol rol;

   public Usuario(UsuarioInsertDTO usuarioInsertDTO){
       this.nombre = usuarioInsertDTO.nombre();
       this.apellido_paterno =usuarioInsertDTO.apellido_paterno();
       this.apellido_materno = usuarioInsertDTO.apellido_materno();;
       this.cedula = usuarioInsertDTO.cedula();
       this.login = usuarioInsertDTO.login();
       this.contrasenia = usuarioInsertDTO.contrasenia();;
       this.rol = usuarioInsertDTO.rol();
   }

}
