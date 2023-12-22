package com.crud_alquiler.domain.usuario.repository;

import com.crud_alquiler.domain.usuario.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que proporciona metodos para acceder y manipular la entidad de Usuario
 * en la base de datos. Extiende de JpaRepository para operaciones basicas de CRUD y
 * consultas.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
