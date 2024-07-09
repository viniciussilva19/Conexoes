create database Conexoes;
use Conexoes;

create table usuario(
idusuario int primary key auto_increment not null,
nome varchar(150),
email varchar(100),
celular varchar(45),
senha varchar(45),
endereco varchar(45)
) Engine = InnoDB;