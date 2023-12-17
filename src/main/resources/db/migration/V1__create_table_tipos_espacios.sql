CREATE TABLE tipos_espacios(
    id bigint not null auto_increment,
    tipos_espacios_name varchar(100) not null unique,

    primary key (id)
);