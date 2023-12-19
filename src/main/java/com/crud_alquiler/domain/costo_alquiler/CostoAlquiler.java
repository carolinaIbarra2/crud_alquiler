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
    @Column(name = "costo_dia")
    private double costoDia;
    @Column(name = "fecha_inicial")
    private LocalDateTime fechaInicial;
    @Column(name = "fecha_final")
    private LocalDateTime fechaFinal;

    public CostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO, EspacioFisico espacioFisico){
            this.espacioFisico = espacioFisico;
            this.costoDia = costoAlquilerInsertDTO.costoDia();
            this.fechaInicial = costoAlquilerInsertDTO.fechaInicial();
            this.fechaFinal = costoAlquilerInsertDTO.fechaFinal();
    }

    public void updateCostoAlquiler(CostoAlquilerUpdateDTO costoAlquilerUpdateDTO, EspacioFisico espacioFisico){
        if (espacioFisico != null){
            this.espacioFisico = espacioFisico;
        }
        if (costoAlquilerUpdateDTO.costoDia() != 0){
            this.costoDia = costoAlquilerUpdateDTO.costoDia();
        }
        if (costoAlquilerUpdateDTO.fechaInicial() != null){
            this.fechaInicial = costoAlquilerUpdateDTO.fechaInicial();
        }
        if (costoAlquilerUpdateDTO.fechaFinal() != null){
            this.fechaFinal = costoAlquilerUpdateDTO.fechaFinal();
        }
    }
}
