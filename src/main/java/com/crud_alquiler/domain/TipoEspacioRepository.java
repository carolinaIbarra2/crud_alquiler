package com.crud_alquiler.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoEspacioRepository extends JpaRepository<TipoEspacio, Long> {
    /*
    @Query("SELECT TE FROM TipoEspacio TE")
    Page<TipoEspacio> findAllTipoEspacio(Pageable pageable);*/
}
