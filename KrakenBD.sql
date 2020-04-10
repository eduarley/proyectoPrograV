--Creación de la BD
create database KrakenBD

use KrakenBD

--Tablas

create table Usuario
(
	id int not null,
	nombre varchar(50),
	clave varchar(30),
	direccion varchar(50),
	telefono varchar(8),
	rol varchar(15),
	estado varchar(10)
)

create table DireccionEntrega
(
	id int identity(1,1) not null,
	idUsuario int not null,
	direccion varchar(1000)
)

create table HorarioEntrega
(
	id int identity(1,1) not null,
	idUsuario int not null,
	horaInicio varchar(50),
	horaFin varchar(50)
)

create table Producto
(
	id int not null identity(1,1),
	descripcion varchar(50),
	urlImagen varchar(1500),
	precio  money,
	existencias int,
	tipo varchar(50),
	ingredientes varchar(1500),
	estado int
)

create table Pedido
(
	id int identity(1,1) not null,
	idUsuario int,
	--idDireccion int,
	fechaEntrega varchar(50),
	horarioEntrega varchar(50),
	direccionEntrega varchar(1000),
	monto money,
	estado varchar(30)
)

create table Despacho
(
	id int identity(1,1) not null,
	idEncFactura int,
	fechaEnvio date,
	medio varchar(30),
	estado int
)

create table EncFactura
(
	id int identity(1,1) not null,
	idUsuario int not null,
	idPedido int not null,
	idDireccion int not null,
	tipoPago varchar(20),
	subTotal money,
	iva money,
	descuento money,
	total money
)

create table DetPedido
(
	idPedido int not null,
	idProducto int not null,
	--idProducto int,
	cantidad int,
	precio money
)

create table DetFactura
(
	idEncFactura int not null,
	idProducto int not null,
	cantidad int,
	precio money
)

create table DetDespacho
(
	idDespacho int not null,
	idProducto int not null,  --idEncFactura
	cantidad int,
	precio money
)

create table CXC
(
	idEncFactura int not null,
	idUsuario int not null
)

--Llaves primarias
alter table Usuario add constraint PK_Usuario primary key (id)
alter table Producto add constraint PK_Producto primary key (id)
alter table Pedido add constraint PK_Pedido primary key (id)
alter table EncFactura add constraint PK_EncFactura primary key (id)
alter table DireccionEntrega add constraint PK_DireccionEntrega primary key (id, idUsuario)
alter table Despacho add constraint PK_Despacho primary key (id)
alter table CXC add constraint PK_Cxc primary key (idEncFactura, idUsuario)
alter table DetFactura add constraint PK_DetFactura primary key (idEncFactura, idProducto)
alter table DetPedido add constraint PK_DetPedido primary key (idPedido, idProducto)
--alter table DetPedido add constraint PK_DetPedido primary key (idPedido)
alter table HorarioEntrega add constraint PK_HorarioEntrega primary key (id,idUsuario)
alter table DetDespacho add constraint PK_DetDespacho primary key (idDespacho, idProducto)



--Llaves foráneas
--alter table Telefono add constraint FK_UsuarioTelefono foreign key (idUsuario) references Usuario(id)
alter table DireccionEntrega add constraint FK_UsuarioDireccionEntrega foreign key (idUsuario) references Usuario(id)
alter table CXC add constraint FK_UsuarioCXC foreign key (idUsuario) references Usuario(id)
alter table HorarioEntrega add constraint FK_HorarioEntrega foreign key (idUsuario) references Usuario(id)

alter table Pedido add constraint FK_UsuarioPedido foreign key (idUsuario) references Usuario(id)
alter table DetPedido add constraint FK_PedidoDetPedido foreign key (idPedido) references Pedido(id)
alter table DetPedido add constraint FK_ProductoDetPedido foreign key (idProducto) references Producto(id)



alter table DetFactura add constraint FK_EncFacturaDetFactura foreign key (idEncFactura) references EncFactura(id)
alter table DetFactura add constraint FK_ProductoDetFactura foreign key (idProducto) references Producto(id)




alter table DetDespacho add constraint FK_DespachoDetDespacho foreign key (idDespacho) references Despacho(id)
alter table DetDespacho add constraint FK_ProductoDetDespacho foreign key (idProducto) references Producto(id)



alter table EncFactura add constraint FK_UsuarioEncFactura foreign key (idUsuario) references Usuario(id)


alter table Despacho add constraint FK_EncFacturaDespacho foreign key (idEncFactura) references EncFactura(id)



alter table CXC add constraint FK_EncFacturaCXC foreign key (idEncFactura) references EncFactura(id)



alter table EncFactura add constraint FK_PedidoEncFactura foreign key (idPedido) references Pedido(id)
------------------------------------------------


Insert into Usuario values (1, 'Eduardo Arley', '1', 'Naranjo', '64488685', 'admin', 'activo')
Insert into Usuario values (123456, 'Bananito Pérez', '1234', 'Chilamate de Poás', '86758675', 'admin', 'activo')
Insert into Usuario values (1234, 'Eldes Pelote', '1234', 'Sarchí', '60973263', 'cliente', 'activo')



--insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
--values ('','','','','','','');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Gallo Pinto','https://www.elmundo.cr/wp-content/uploads/2017/03/gallo-pinto1.jpg','1500','10','Desayuno','Arroz, frijoles y salsa Lizano','1');


insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Casado','https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Casado_costarricense2.png/220px-Casado_costarricense2.png','2000','5','Almuerzo','Arroz, frijoles y carne en salsa','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Taco al pastor','https://www.comedera.com/wp-content/uploads/2017/08/tacos-al-pastor-receta.jpg','1250','5','Cena','Tortilla de maíz con carne y especias','1');



/*insert into DireccionEntrega(idUsuario, direccion) values (1234, 'Chilamate de Poás')
insert into DireccionEntrega(idUsuario, direccion) values (1234, 'San Rafael de Poás')
insert into DireccionEntrega(idUsuario, direccion) values (1234, 'San Pedro de Poás')



insert into HorarioEntrega(idUsuario, horaInicio, horaFin) values (1234, '10:00AM', '11:30AM')
insert into HorarioEntrega(idUsuario, horaInicio, horaFin) values (1234, '1:00PM', '4:30PM')*/



/*insert into Pedido(idUsuario, fechaEntrega, horarioEntrega, direccionEntrega, monto, estado) values (1234, '30/04/2020', '10:00AM a 11:30AM', 'San Rafael de Poás', 3500, 'pendiente')



insert into DetPedido(idPedido, idProducto, cantidad, precio) values (1, 1, 1, 1500)
insert into DetPedido(idPedido, idProducto, cantidad, precio) values (1, 2, 1, 2000)*/


/*

alter table EncFactura add constraint FK_EncFacturaDireccionEntrega foreign key (idDireccion) references DireccionEntrega(id)
*/




--PROCEDIMIENTOS ALMACENADOS





--PRUEBAS
select * from Usuario
select * from DireccionEntrega
select * from HorarioEntrega

select * from Pedido
select * from DetPedido


delete from Pedido
delete from DetPedido