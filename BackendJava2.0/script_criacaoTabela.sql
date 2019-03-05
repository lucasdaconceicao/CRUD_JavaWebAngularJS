
create database base_usuario;
use base_usuario;
create table usuarios(
	id integer not null primary key auto_increment,
    nome varchar(100)not null,
    email varchar(100) not null,
    cpf varchar(11) not null
);






