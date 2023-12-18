create table costos_alquileres(
    id bigint not null auto_increment,
    id_espacios_fisicos bigint not null,
    costo_dia double,
    fecha_inicial DATETIME NOT NULL,
    fecha_final DATETIME NOT NULL,

    primary key (id),
    constraint fk_costos_alquileres_espacios_fisicos_id foreign key(id_espacios_fisicos)
        references espacios_fisicos(id)
);