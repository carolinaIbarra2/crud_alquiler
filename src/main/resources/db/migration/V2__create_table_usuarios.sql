CREATE TABLE usuarios(
        id bigint not null auto_increment,
        nombre varchar(50) not null,
        apellido_paterno varchar(50) not null,
        apellido_materno varchar(50) not null,
        cedula varchar(15) not null unique,
        login varchar(50) not null unique,
        contrasenia varchar(50) not null,
        rol varchar(13) not null,
        primary key (id)
);