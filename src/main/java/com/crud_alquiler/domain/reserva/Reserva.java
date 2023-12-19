package com.crud_alquiler.domain.reserva;

import com.crud_alquiler.domain.espacio_fisico.EspacioFisico;
import com.crud_alquiler.domain.reserva.dto.ReservaInsertDTO;
import com.crud_alquiler.domain.reserva.dto.ReservaUpdateDTO;
import com.crud_alquiler.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private LocalDateTime fecha_reserva;

    private double costo_reserva;

    private double penalidad;

    public Reserva(ReservaInsertDTO reservaInsertDTO, EspacioFisico espacioFisico,Usuario usuario){
        this.espacioFisico = espacioFisico;
        this.usuario = usuario;
        this.fecha_reserva = reservaInsertDTO.fecha_reserva();
        this.costo_reserva = reservaInsertDTO.costo_reserva();
        this.penalidad = reservaInsertDTO.penalidad();
    }

    public void updateReserva(ReservaUpdateDTO reservaUpdateDTO, EspacioFisico espacioFisico,
                              Usuario usuario){
        if (espacioFisico != null){
            this.espacioFisico = espacioFisico;
        }
        if (usuario != null){
            this.usuario = usuario;
        }
        if (reservaUpdateDTO.fecha_reserva() != null){
            this.fecha_reserva = reservaUpdateDTO.fecha_reserva();
        }
        if (reservaUpdateDTO.costo_reserva() != 0){
            this.costo_reserva = reservaUpdateDTO.costo_reserva();
        }
        if (reservaUpdateDTO.penalidad() != 0){
            this.penalidad = reservaUpdateDTO.penalidad();
        }
    }

}
