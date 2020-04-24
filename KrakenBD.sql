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

create table DetPedido
(
	idPedido int not null,
	idProducto int not null,
	--idProducto int,
	cantidad int,
	precio money
)

create table EncFactura
(
	id int identity(1,1) not null,
	idUsuario int not null,
	idPedido int not null,
	direccion varchar(1000),
	tipoPago varchar(20),
	subTotal money,
	iva money,
	descuento money,
	total money,
	estadoDespacho varchar(40)
)

create table DetFactura
(
	idEncFactura int not null,
	idProducto int not null,
	cantidad int,
	precio money
)

create table Despacho
(
	id int identity(1,1) not null,
	idEncFactura int,
	fechaEnvio varchar(40),
	medio varchar(30),
	estado int
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
Insert into Usuario values (123456, 'Ignacio Santos', '1234', 'Chilamate de Poás', '86758675', 'admin', 'activo')
Insert into Usuario values (1234, 'Edgar Silva', '1234', 'Sarchí', '60973263', 'cliente', 'activo')


insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Gallo Pinto','https://www.elmundo.cr/wp-content/uploads/2017/03/gallo-pinto1.jpg','1500','10','Desayuno','Arroz, frijoles y salsa Lizano','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Casado','https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Casado_costarricense2.png/220px-Casado_costarricense2.png','2000','5','Almuerzo','Arroz, frijoles y carne en salsa','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Taco al pastor','https://www.comedera.com/wp-content/uploads/2017/08/tacos-al-pastor-receta.jpg','1250','5','Cena','Tortilla de maíz con carne y especias','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Filet de pescado','https://www.enmicocinahoy.cl/wp-content/uploads/2017/04/pescado-plancha-sarten-7.jpg','1800','20','Almuerzo','Pescado con salsa blanca y limon','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Sopa de mariscos','https://recetasdecocina.elmundo.es/wp-content/uploads/2018/11/receta-sopa-pescado.jpg','2300','17','Cena','Mariscos en sustancia con olores','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Sopa de lentejas','https://www.mexicoenmicocina.com/wp-content/uploads/2018/04/sopa-de-lentejas-500x500.jpg','1300','28','Cena','Lentejas, zanahoria, pan, olores','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Pupusas','https://cdn.kiwilimon.com/recetaimagen/2806/th5-640x426-25790.jpg','1500','8','Desayuno','Harina, queso, frijoles, salsa de tomate','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Hamburguesas artesanal','https://www.revistaperfil.com/resizer/6CJEQRAhqM0UZfozMPxCM1Ezcz8=/600x0/center/middle/filters:quality(100)/arc-anglerfish-arc2-prod-gruponacion.s3.amazonaws.com/public/QCRITEDPYNEV7KOS6IRT3OGWI4.jpg','2100','10','Almuerzo','Pan, lechuga, tomate, queso, salsas, pepinillos, papas','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Chop suey','https://s3.amazonaws.com/arc-wordpress-client-uploads/infobae-wp/wp-content/uploads/2017/08/17091552/Jueves-QC-Chop-suey-con-pollo.jpg','2500','21','Almuerzo','Pasta, verduras, salsa inglesa, carne','1');

insert into Producto(descripcion,urlImagen,precio,existencias,tipo,ingredientes,estado)
values ('Arroz con camarones','https://www.laylita.com/recetas/wp-content/uploads/Receta-de-arroz-con-camarones.jpg','3000','13','Desayuno','Camarones, arroz, olores','1');


--Trigger para reducir existencias del producto después de insertar los DetFactura
create trigger TR_ActualizarExistencia
on DetFactura
after insert
as
begin
	set nocount on;

	update Producto
	set existencias= (select p.existencias from Producto p, inserted where inserted.idProducto=p.id)-1
	from inserted
	where Producto.id= inserted.idProducto
end