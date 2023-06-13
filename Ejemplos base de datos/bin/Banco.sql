drop database if exists banco;
create database banco;
use banco;

create table clientes (
	dni varchar(10),
	nombre varchar(50) not null,
	telefono varchar(10) not null,
	direccion varchar(50) not null,
	primary key (dni)
);

create table cuenta (
	numero_cuenta integer unsigned not null,
	dni_cliente varchar(10),
	estado enum('activa','baja') default 'activa',
    saldo double unsigned not null,
	primary key (numero_cuenta),
	foreign key (dni_cliente) references clientes(dni)
);

create table movimientos (
	id int auto_increment,
    numero_cuenta integer unsigned not null,
    importe double unsigned not null,
    fecha date not null,
    tipo enum('ingreso','salida','transferencia enviada','transferencia recibida'),
    numero_cuenta_transferencia integer unsigned not null,
    concepto varchar(100),
    primary key (id),
    foreign key (numero_cuenta) references cuenta(numero_cuenta),
    foreign key (numero_cuenta_transferencia) references cuenta(numero_cuenta)
);
