package com.crud_alquiler.controller;

import com.crud_alquiler.domain.usuario.UsuarioService;
import com.crud_alquiler.domain.usuario.dto.UsuarioInsertDTO;
import com.crud_alquiler.domain.usuario.dto.UsuarioRespuestaDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;

@RestController /*se utiliza para marcar una clase como un controlador que maneja las solicitudes HTTP
y proporciona respuestas JSON directamente.*/
@RequestMapping("usuario")  /*se utiliza para asignar solicitudes HTTP a métodos específicos en el
 controlador.En este caso, el @RequestMapping está a nivel de clase, lo que significa que todas las
 solicitudes que comienzan con /usuario serán manejadas por este controlador.*/
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")  /*indica que este método manejará peticiones HTTP GET a una URL que incluya
    un parámetro {id}
    ResponseEntity:esta clase representa toda la respuesta HTTP. Se puede controlar y personalizar la respuesta
    que se envía al cliente.
    este método maneja solicitudes GET a una URL específica que contiene un parámetro de identificación (id).
    Luego, utilizando un servicio dedicado (usuarioService), recupera la información del usuario correspondiente
     a ese id y devuelve esa información en el cuerpo de la respuesta HTTP.
    */
    public ResponseEntity<UsuarioRespuestaDTO> getUsuario(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.getUsuario(id));
    }

    @GetMapping
    /*Page es una interfaz que proporciona métodos para trabajar con resultados paginados, permitiendo dividir
     grandes conjuntos de datos en páginas más pequeñas.
     Este método permite obtener una lista paginada de usuarios a través de una solicitud HTTP, permitiendo al
     cliente controlar la paginación mediante los parámetros de la URL, como el número de página y el tamaño de
     la página.
      */
    public ResponseEntity<Page<UsuarioRespuestaDTO>> getAllUsuario(
            @PageableDefault(size=5, sort = "id")Pageable pageable){
        return ResponseEntity.ok(usuarioService.findByUsuario(pageable));
    }

    @PostMapping   /*se utiliza para mapear las solicitudes HTTP POST a métodos específicos en un controlador*/
    @Transactional  /*se utiliza para gestionar transacciones en operaciones relacionadas con bases de datos
    Esto significa que todas las operaciones deben completarse con éxito para que la transacción sea
    confirmada (commit); de lo contrario, si alguna operación falla, se revierten todas las operaciones
    (rollback) para mantener la consistencia de la base de datos.
    */
    /*Este método maneja solicitudes HTTP POST para insertar un nuevo usuario. Toma un objeto
     UsuarioInsertDTO del cuerpo de la solicitud, validándolo mediante la anotación @Valid, lo que activa la
     validación de bean estándar de Java.  Crea una URL para la ubicación del nuevo recurso de usuario creado.
     La URI se genera utilizando UriComponentsBuilder, reemplazando {id} con el identificador del nuevo
     usuario (probablemente obtenido de usuarioRespuestaDTO.getId()). Retorna una respuesta HTTP con el código
     de estado 201 (CREATED) utilizando ResponseEntity.created(url)*/
    public ResponseEntity<UsuarioRespuestaDTO> insertUsuario(
        @Valid @RequestBody UsuarioInsertDTO usuarioInsertDTO, UriComponentsBuilder uriComponentsBuilder){
        UsuarioRespuestaDTO usuarioRespuestaDTO = usuarioService.insertUsuario(usuarioInsertDTO);
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuarioRespuestaDTO.id()).toUri();
        return ResponseEntity.created(url).body(usuarioRespuestaDTO);
    }


}
