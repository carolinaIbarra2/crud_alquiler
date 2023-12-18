package com.crud_alquiler.domain.espacio_fisico;

import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoInsertDTO;
import com.crud_alquiler.domain.espacio_fisico.dto.EspacioFisicoUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.TipoEspacio;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    public EspacioFisico(EspacioFisicoInsertDTO espacioFisicoInsertDTO, TipoEspacio tipoEspacio){
        this.tipoEspacio = tipoEspacio;
        this.nombre = espacioFisicoInsertDTO.nombre();
        this.capacidad = espacioFisicoInsertDTO.capacidad();
        this.descripcion = espacioFisicoInsertDTO.descripcion();
    }

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
