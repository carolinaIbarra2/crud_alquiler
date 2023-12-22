package com.crud_alquiler.domain.reserva.entidades;

import com.crud_alquiler.domain.espacio_fisico.entidades.EspacioFisico;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.entidades.dto.ReservaUpdateDTO;
import com.crud_alquiler.domain.usuario.entidades.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa la entidad Reserva que almacena la información relacionada con las reservas.
 */
@Entity(name = "Reserva")
@Table(name = "reservas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_espacios_fisicos")
    private EspacioFisico espacioFisico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuarios")
    private Usuario usuario;
    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "costo_reserva")
    private double costoReserva;

    private double penalidad;

    /**
     * Constructor que inicializa un objeto Reserva a partir de un objeto ReservaInsertDTO y Usuario
     * @param reservaInsertDTO El DTO con la información para la creación de la reserva.
     * @param espacioFisico El espacio fisico asociado a la reserva
     * @param usuario El usuario asociado a la reserva
     */
    public Reserva(ReservaInsertDTO reservaInsertDTO, EspacioFisico espacioFisico,Usuario usuario){
        this.espacioFisico = espacioFisico;
        this.usuario = usuario;
        this.fechaReserva = reservaInsertDTO.fechaReserva();
        this.penalidad = reservaInsertDTO.penalidad();
    }

    /**
     * Método que actualiza los datos de un objeto Reserva con la información proporcionada en un DTO de
     * actualización.
     * @param reservaUpdateDTO El DTO con la información actualizada para la reserva.
     * @param espacioFisico El espacio fisico actualizado asociado a la reserva.
     * @param usuario El usuario actualizado asociado a la reserva.
     */
    public void updateReserva(ReservaUpdateDTO reservaUpdateDTO, EspacioFisico espacioFisico,
                              Usuario usuario){
        if (espacioFisico != null){
            this.espacioFisico = espacioFisico;
        }
        if (usuario != null){
            this.usuario = usuario;
        }
        if (reservaUpdateDTO.fechaReserva() != null){
            this.fechaReserva = reservaUpdateDTO.fechaReserva();
        }
        if (reservaUpdateDTO.penalidad() != 0){
            this.penalidad = reservaUpdateDTO.penalidad();
        }
    }

}
