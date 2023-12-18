package com.crud_alquiler.domain.costo_alquiler;

import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.dto.CostoAlquilerUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "CostoAlquiler") /*mapea una clase Java a una tabla en una base de datos relacional.
Cada instancia de esta clase representa una fila en esa tabla.*/
@Table(name = "costos_alquileres")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CostoAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) /*se utiliza para especificar que el valor de una clave
     primaria en una entidad será generado automáticamente por la base de datos utilizando una estrategia de */
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_espacios_fisicos")
    private EspacioFisico espacioFisico;

    private double costo_dia;
    private LocalDateTime fecha_inicial;
    private LocalDateTime fecha_final;

    public CostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO, EspacioFisico espacioFisico){
            this.espacioFisico = espacioFisico;
            this.costo_dia = costoAlquilerInsertDTO.costo_dia();
            this.fecha_inicial = costoAlquilerInsertDTO.fecha_inicial();
            this.fecha_final = costoAlquilerInsertDTO.fecha_final();
    }

    public void updateCostoAlquiler(CostoAlquilerUpdateDTO costoAlquilerUpdateDTO, EspacioFisico espacioFisico){
        if (espacioFisico != null){
            this.espacioFisico = espacioFisico;
        }
        if (costo_dia != 0){
            this.costo_dia = costoAlquilerUpdateDTO.costo_dia();
        }
        if (fecha_inicial != null){
            this.fecha_inicial = costoAlquilerUpdateDTO.fecha_inicial();
        }
        if (fecha_final != null){
            this.fecha_final = costoAlquilerUpdateDTO.fecha_final();
        }
    }
}
