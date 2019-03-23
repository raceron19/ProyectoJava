use sys;
drop database if exists ticketstesa;
create database ticketstesa;
use ticketstesa;
create table roles(
id int auto_increment primary key,
rname varchar(40),
descrip text not null);

create table departments(
id varchar(3) primary key not null,
dname varchar(250) not null);

create table employees(
id int auto_increment primary key,
rol int not null,
fname varchar(250) not null, 
lname varchar(250) not null,
email varchar(250) not null,
passwd varchar(64) not null,
chief int null default null,
department varchar(3) not null,
created_at timestamp null default now(),
updated_at timestamp null default now(),
foreign key (rol) references roles(id),
foreign key (department) references departments(id));

create table request_types(
id int auto_increment primary key,
rt_name varchar(100));

create table request_status(
id int auto_increment primary key, 
rs_name varchar(100));

create table case_status(
id int auto_increment primary key,
cs_name varchar(100));

create table requests(
id int auto_increment primary key,
request_type int not null,
department varchar(3) not null,
title varchar(255) not null,
descrip text not null,
created_by int not null, 
request_status int not null,
commentary text null, 
created_at timestamp not null default now(),
updated_at timestamp null,
foreign key (department) references departments(id),
foreign key (request_type) references request_types(id),
foreign key (created_by) references employees(id),
foreign key (request_status) references request_status(id));

create table cases(
id  varchar(8) primary key,
request int not null, 
assigned_to int not null,
case_status int not null,
deadline timestamp not null,
descrip text not null, 
percent decimal(5,2) not null default 0.0,
tester int null default null, 
created_at timestamp not null default now(),
updated_at timestamp null, 
to_production timestamp null,
foreign key (request) references requests(id),
foreign key (assigned_to) references employees(id),
foreign key (case_status) references case_status(id),
foreign key (tester) references employees(id));

create table binnacle(
id int auto_increment primary key,
case_id varchar(8) not null,
commentary text not null,
created_at timestamp not null default now(),
foreign key (case_id) references cases(id));

insert into roles values(null, 'Administrador', 'Con la capacidad de registrar y gestionar �reas funcionales de la empresa (departamentos), jefes de �reas funcionales y jefes de desarrollo.'),
						(null, 'Jefe de �rea funcional', 'Con la capacidad de solicitar la apertura de casos y monitorear el porcentaje de progreso y bit�cora de los casos aperturados.'),
                        (null, 'Empleado de �rea funcional', 'Pueden ser asignados como �probadores� de un caso, en tal situaci�n deben monitorear el porcentaje de progreso y bit�coras de trabajo de dicho caso y aprobarlo o rechazarlo una vez que este haya sido entregado por el programador asignado.'), 
                        (null, 'Jefe de desarrollo', 'Tiene la capacidad de aceptar o rechazar las solicitudes de casos realizadas por los jefes de las �reas funcionales que tiene a su cargo. Adem�s, debe tener la capacidad de monitorear el trabajo de los programadores que tiene a su cargo.'), 
                        (null, 'Programador', 'Debe actualizar los porcentajes de progreso y bit�coras de trabajo de los casos a los que ha sido asignado.');
                        
insert into departments values	('DST', 'Departamento de Sistemas'),
								('DFN', 'Departamento de Finanzas'),
                                ('DVT', 'Departamento de Ventas'),
                                ('DFF', 'Departamento de Facturaci�n Fija'),
                                ('DFM', 'Departamento de Facturaci�n M�vil');
                                
insert into request_types values(null, 'Nuevo sistema'),
								(null, 'Nueva funcionalidad'),
                                (null, 'Correcci�n de sistema');
                                
insert into request_status values	(null, 'En espera de respuesta'),
									(null, 'Solicitud rechazada'),
									(null, 'En desarrollo'),
                                    (null, 'Cerrado');
                                    
insert into case_status values	(null, 'En desarrollo'),
                                (null, 'Esperando aprobaci�n del �rea solicitante'),
								(null, 'Vencido'),
                                (null, 'Devuelto con observaciones'),
                                (null, 'Finalizado');
                                                                
insert into employees values(null, 1, 'Eduardo', 'Henr�quez', 'eduard_alfons@hotmail.com', sha2('password', 256), null, 'DST', now(), null);
insert into employees values(null, 2, 'Jos�', 'Ar�valo', 'JefeFuncional', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 3, 'Jos�', 'Ar�valo', 'EmpleadoFuncional', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 4, 'Jos�', 'Ar�valo', 'JefeDesarrollo', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 5, 'Jos�', 'Ar�valo', 'EmpleadoDesarrollo', sha2('pasword2', 256), null, 'DST', now(), null);
DELIMITER //
CREATE PROCEDURE sp_select_user (
    IN email VARCHAR(250),
    IN passwd VARCHAR(64))
BEGIN
IF ((Select count(*) from employees where employees.email = email and employees.passwd = sha2(passwd, 256)) = 1) THEN
SELECT e.id, r.rname as 'Rol', e.id, concat(e.fname, ' ', e.lname) as 'Nombre', e.email as 'Correo', e.chief as 'Superior', d.dname as 
'Departamento', NULL as 'Error' from roles r inner join employees e on r.id = e.rol inner join departments d on d.id = e.department where 
e.email = email and e.passwd = SHA2(passwd, 256); 
ELSEIF ((Select count(*) from employees where employees.email = email) = 0) THEN
SELECT NULL as 'id', NULL as 'Rol', NULL as 'Nombre', NULL as 'Correo', NULL as 'Superior', NULL as 'Departamento', 'No se encontr� ning�n usuario' as 'Error';
ELSE 
SELECT NULL as 'id', NULL as 'Rol', NULL as 'Nombre', NULL as 'Correo', NULL as 'Superior', NULL as 'Departamento', 'Contrase�a incorrecta' as 'Error';
END IF;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_select_roles ()
BEGIN
SELECT id, rname as rol from roles;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_select_departments ()
BEGIN
SELECT id, dname as departamento from departments;
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_select_users ()
BEGIN
SELECT e.id as 'ID', r.rname as 'Rol', e.id, e.fname as 'Nombres', e.lname as 'Apellidos', e.email as 'Correo', e.chief as 'Superior', 
d.dname as 'Departamento', e.created_at as 'Fecha de creacin', NULL as 'Error' from roles r inner join employees e on r.id = e.rol inner 
join departments d on d.id = e.department;
END//
DELIMITER ;