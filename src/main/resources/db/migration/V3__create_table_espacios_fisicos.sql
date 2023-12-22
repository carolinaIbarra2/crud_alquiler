create table espacios_fisicos(
    id bigint not null auto_increment,
    id_tipo_espacio bigint not null,
    nombre varchar(100) not null unique,
    capacidad smallint not null,
    descripcion varchar(200),

    primary key (id),
    constraint fk_espacios_fisicos_tipo_espacio_id foreign key(id_tipo_espacio) references tipos_espacios(id)
);