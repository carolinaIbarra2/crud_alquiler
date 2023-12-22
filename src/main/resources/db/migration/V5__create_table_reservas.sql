create table reservas(
    id bigint not null auto_increment,
    id_espacios_fisicos bigint not null,
    id_usuarios bigint not null,
    fecha_reserva DATETIME NOT NULL,
    costo_reserva double not null ,
    penalidad double,

    primary key (id),
    constraint fk_reservas_espacios_fisicos_id foreign key (id_espacios_fisicos) references espacios_fisicos(id),
    constraint fk_reservas_usuarios_id foreign key (id_usuarios) references usuarios(id)
);