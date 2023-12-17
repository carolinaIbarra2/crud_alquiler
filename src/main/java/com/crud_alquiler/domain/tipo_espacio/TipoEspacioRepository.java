package com.crud_alquiler.domain.tipo_espacio;

import com.crud_alquiler.domain.tipo_espacio.TipoEspacio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEspacioRepository extends JpaRepository<TipoEspacio, Long> {
    /*
    @Query("SELECT TE FROM TipoEspacio TE")
    Page<TipoEspacio> findAllTipoEspacio(Pageable pageable);*/
}
