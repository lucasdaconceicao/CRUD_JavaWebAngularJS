--Para rodar o projeto é preciso ter um usuario com o nome "root" com uma senha também "root"

create database base_usuario;
use base_usuario;
create table usuarios(
	id integer not null primary key auto_increment,
    nome varchar(100)not null,
    email varchar(100) not null,
    cpf varchar(11) not null
);






