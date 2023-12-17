package com.crud_alquiler.domain;

import jakarta.persistence.*;
import lombok.*;

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

}
