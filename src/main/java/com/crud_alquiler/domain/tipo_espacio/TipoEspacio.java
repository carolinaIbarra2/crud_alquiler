package com.crud_alquiler.domain.tipo_espacio;

import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioUpdateDTO;
import com.crud_alquiler.domain.tipo_espacio.dto.TipoEspacioInsertDTO;
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

    public TipoEspacio(TipoEspacioInsertDTO tipoEspacioInsertDTO){
         this.tipoEspacio = tipoEspacioInsertDTO.tipoEspacio();
    }

    public void updateTipoEspacio(TipoEspacioUpdateDTO tipoEspacioUpdateDTO){
        if(tipoEspacioUpdateDTO.tipoEspacio() != null){
            this.tipoEspacio = tipoEspacioUpdateDTO.tipoEspacio();
        }
    }


}
