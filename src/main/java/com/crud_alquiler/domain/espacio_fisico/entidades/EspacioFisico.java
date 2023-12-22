package com.crud_alquiler.domain.espacio_fisico.entidades;

import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.entity.TipoEspacio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Representa la entidad EspacioFisico que almacena la información relacionada con los espacios fisicos.
 */
@Table(name = "espacios_fisicos")
@Entity(name = "EspacioFisico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EspacioFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_espacio")
    private TipoEspacio tipoEspacio;

    private String nombre;
    private int capacidad;
    private String descripcion;

    /**
     * Constructor que inicializa un objeto EspacioFisico a partir de un objeto EspacioFisicoInsertDTO y
     * TipoEspacio.
     * @param espacioFisicoInsertDTO El DTO con la información para la creación del espacio fisico.
     * @param tipoEspacio El tipo de espacio asociado al espacio fisico.
     */
    public EspacioFisico(EspacioFisicoInsertDTO espacioFisicoInsertDTO, TipoEspacio tipoEspacio){
        this.tipoEspacio = tipoEspacio;
        this.nombre = espacioFisicoInsertDTO.nombre();
        this.capacidad = espacioFisicoInsertDTO.capacidad();
        this.descripcion = espacioFisicoInsertDTO.descripcion();
    }

    /**
     * Método que actualiza los datos de un objeto EspacioFisico con la información proporcionada en un DTO de
     * actualización.
     * @param espacioFisicoUpdateDTO El DTO con la información actualizada para el espacio fisico.
     * @param tipoEspacio El tipo de espacio actualizado asociado al espacio fisico.
     */
    public void updateEspacioFisico(EspacioFisicoUpdateDTO espacioFisicoUpdateDTO, TipoEspacio tipoEspacio){
        if (tipoEspacio != null){
            this.tipoEspacio = tipoEspacio;
        }
        if (espacioFisicoUpdateDTO.nombre() != null){
            this.nombre = espacioFisicoUpdateDTO.nombre();
        }
        this.capacidad = espacioFisicoUpdateDTO.capacidad();
        if (espacioFisicoUpdateDTO.descripcion() != null){
            this.descripcion = espacioFisicoUpdateDTO.descripcion();
        }
    }

}
