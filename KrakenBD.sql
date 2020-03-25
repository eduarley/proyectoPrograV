--Creaci�n de la BD
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
	direccion varchar(50)
)

create table HorarioEntrega
(
	id int identity(1,1) not null,
	idUsuario int not null,
	hora time(2)
)

create table Producto
(
	id int not null identity(1,1),
	descripcion varchar(50),
	imagen image,
	precio  money,
	existencias int,
	tipo varchar(50),
	ingredientes varchar(200),
	estado int
)

create table Pedido
(
	id int identity(1,1) not null,
	idUsuario int,
	idDireccion int,
	fechaEntrega date,
	horarioEntrega time(2),
	direccionEntrega varchar(50),
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
	iva money,
	descuento money,
	total money
)

create table DetPedido
(
	idPedido int not null,
	idProducto int not null,
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
alter table HorarioEntrega add constraint PK_HorarioEntrega primary key (id,idUsuario)
alter table DetDespacho add constraint PK_DetDespacho primary key (idDespacho, idProducto)



--Llaves for�neas
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



Insert into Usuario values (123456, 'Bananito P�rez', 'Sa', 'Chilamate de Po�s', '86758675', 'admin', 'activo')
Insert into Usuario values (1234, 'Eldes Pelote', 'Sa', 'Sarch�', '60973263', 'cliente', 'inactivo')
/*

alter table EncFactura add constraint FK_EncFacturaDireccionEntrega foreign key (idDireccion) references DireccionEntrega(id)
*/




--PROCEDIMIENTOS ALMACENADOS



--Inserts

--Insertar Cliente
create procedure PA_InsertarCliente
	@id int not null,
	@nombre varchar(30),
	@direccion varchar(50),
	@telefono nvarchar(15),
	@estado int

AS
BEGIN
	INSERT INTO Cliente(id, nombre, direccion, telefono) VALUES (@id, @nombre, @direccion, @telefono, 1)
END

--Insertar Producto
create procedure PA_InsertarProducto
	@foto image,
	@precio  decimal,
	@cantidadDisponible int,
	@estado int

AS
BEGIN
	INSERT INTO Producto(foto, precio, cantidadDisponible, estado) VALUES (@foto, @precio, @cantidadDisponible, 1)
END

--Insertar ProductoPedido
create procedure PA_InsertarProductoPedido
	@idProducto int,
	@idPedido int,
	@cantidad int

AS
BEGIN
	INSERT INTO ProductoPedido(idProducto, idPedido, cantidad) VALUES (@idProducto, @idPedido, @cantidad)
END

--Insertar Direcci�n Entrega
create procedure PA_InsertarDireccionEntrega
	@idCliente int,
	@direccion varchar(50)

AS
BEGIN
	INSERT INTO DireccionEntrega(idCliente, direccion) VALUES (@idCliente, @direccion)
END

--Insertar Pedido
create procedure PA_InsertarPedido
	@idCliente int,
	@fechaEntrega date,
	@horarioEntrega time,
	@direccionEntrega varchar(50),
	@estado varchar(30)

AS
BEGIN
	INSERT INTO Pedido(idCliente, fechaEntrega,  horarioEntrega,  direccionEntrega,  estado) VALUES (@idCliente, @fechaEntrega,  @horarioEntrega,  @direccionEntrega,  @estado)
END

--Insertar Usuario
create procedure PA_InsertarUsuario
	@id int not null,
	@nombre varchar(50),
	@clave varchar(30),
	@tipoUsuario varchar(40),
	@estado int

AS
BEGIN
	INSERT INTO Usuario(id, nombre, clave, tipoUsuario, estado) VALUES (@id, @nombre, @clave, @tipoUsuario, 1)
END

--Insertar Despacho
create procedure PA_InsertarDespacho
	@idFactura int,
	@fechaEnvio date,
	@horaEnvio time,
	@medio varchar(30),
	@estado int

AS
BEGIN
	INSERT INTO Usuario(id, nombre, clave, tipoUsuario, estado) VALUES (@id, @nombre, @clave, @tipoUsuario, 1)
END