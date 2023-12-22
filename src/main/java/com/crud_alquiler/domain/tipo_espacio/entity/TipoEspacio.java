package com.crud_alquiler.domain.tipo_espacio.entity;

import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.dto.TipoEspacioInsertDTO;
import jakarta.persistence.*;
import lombok.*;

/**
 * Representa la entidad TipoEspacio que almacena la información relacionada con los tipos de espacio.
 */
@Table(name = "tipos_espacios")
@Entity(name = "TipoEspacio")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TipoEspacio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipos_espacios_name")
    private String tipoEspacio;

    /**
     * Constructor que inicializa un objeto TipoEspacio a partir de un objeto TipoEspacioInsertDTO
     * @param tipoEspacioInsertDTO El DTO con la información para la creación de un tipo de espacio.
     */
    public TipoEspacio(TipoEspacioInsertDTO tipoEspacioInsertDTO){
         this.tipoEspacio = tipoEspacioInsertDTO.tipoEspacio();
    }

    /**
     * Método que actualiza los datos de un objeto Tipo de espacio con la información proporcionada en un DTO de
     * actualización.
     * @param tipoEspacioUpdateDTO El DTO con la información actualizada para el tipo de espacio
     */
    public void updateTipoEspacio(TipoEspacioUpdateDTO tipoEspacioUpdateDTO){
        if(tipoEspacioUpdateDTO.tipoEspacio() != null){
            this.tipoEspacio = tipoEspacioUpdateDTO.tipoEspacio();
        }
    }


}
