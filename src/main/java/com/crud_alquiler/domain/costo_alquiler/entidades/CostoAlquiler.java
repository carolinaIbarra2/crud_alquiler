package com.crud_alquiler.domain.costo_alquiler.entidades;

import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerInsertDTO;
import com.crud_alquiler.domain.costo_alquiler.entidades.dto.CostoAlquilerUpdateDTO;
import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa la entidad CostoAlquiler que almacena la información relacionada con los costos de alquiler.
 */
@Entity(name = "CostoAlquiler")
@Table(name = "costos_alquileres")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class CostoAlquiler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    /**
     * Constructor que inicializa un objeto CostoAlquiler a partir de un objeto CostoAlquilerInsertDTO y
     * un EspacioFisico.
     * @param costoAlquilerInsertDTO El DTO con la información para la creación del costo de alquiler.
     * @param espacioFisico El espacio físico asociado al costo de alquiler.
     */
    public CostoAlquiler(CostoAlquilerInsertDTO costoAlquilerInsertDTO, EspacioFisico espacioFisico){
            this.espacioFisico = espacioFisico;
            this.costoDia = costoAlquilerInsertDTO.costoDia();
            this.fechaInicial = costoAlquilerInsertDTO.fechaInicial();
            this.fechaFinal = costoAlquilerInsertDTO.fechaFinal();
    }

    /**
     * Método que actualiza los datos de un objeto CostoAlquiler con la información proporcionada en un DTO de
     * actualización.
     * @param costoAlquilerUpdateDTO El DTO con la información actualizada para el costo de alquiler.
     * @param espacioFisico  El espacio físico actualizado asociado al costo de alquiler.
     */
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
