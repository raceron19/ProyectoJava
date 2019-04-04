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
id int primary key auto_increment,
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
id varchar(8) primary key,
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
foreign key (case_id) references cases(id) on delete cascade);

insert into roles values(null, 'Administrador', 'Con la capacidad de registrar y gestionar áreas funcionales de la empresa (departamentos), jefes de áreas funcionales y jefes de desarrollo.'),
						(null, 'Jefe de área funcional', 'Con la capacidad de solicitar la apertura de casos y monitorear el porcentaje de progreso y bitácora de los casos aperturados.'),
                        (null, 'Empleado de área funcional', 'Pueden ser asignados como probadores de un caso, en tal situación deben monitorear el porcentaje de progreso y bitácoras de trabajo de dicho caso y aprobarlo o rechazarlo una vez que este haya sido entregado por el programador asignado.'), 
                        (null, 'Jefe de desarrollo', 'Tiene la capacidad de aceptar o rechazar las solicitudes de casos realizadas por los jefes de las áreas funcionales que tiene a su cargo. Además, debe tener la capacidad de monitorear el trabajo de los programadores que tiene a su cargo.'), 
                        (null, 'Programador', 'Debe actualizar los porcentajes de progreso y bitácoras de trabajo de los casos a los que ha sido asignado.');
                        
insert into departments values	('DST', 'Departamento de Sistemas'),
								('DFN', 'Departamento de Finanzas'),
                                ('DVT', 'Departamento de Ventas'),
                                ('DFF', 'Departamento de Facturación Fija'),
                                ('DFM', 'Departamento de Facturación Móvil');
                                
insert into request_types values(null, 'Nuevo sistema'),
								(null, 'Nueva funcionalidad'),
                                (null, 'Corrección de sistema');
                                
insert into request_status values	(null, 'En espera de respuesta'),
									(null, 'Solicitud rechazada'),
									(null, 'En desarrollo'),
                                    (null, 'Cerrado');
                                    
                                    
insert into case_status values	(null, 'En desarrollo'),
                                (null, 'Esperando aprobación del área solicitante'),
								(null, 'Vencido'),
                                (null, 'Devuelto con observaciones'),
                                (null, 'Finalizado');
                                                                
insert into employees values(null, 1, 'Eduardo', 'Henríquez', 'eduard_alfons@hotmail.com', sha2('password', 256), null, 'DST', now(), null);
insert into employees values (null, 1, 'Eduardo', 'Arevalo', 'jefe', sha2('123456',256), null, 'DST', now(),null);
insert into employees values(null, 2, 'José', 'Arévalo', 'e@gmail.com', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 2, 'José', 'Arévalo', 'Jefe1', sha2('123456', 256), null, 'DST', now(), null);
insert into employees values(null, 3, 'José', 'Arévalo', 'EmpleadoFuncional', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 4, 'José', 'Arévalo', 'JefeDesarrollo', sha2('pasword2', 256), null, 'DST', now(), null);
insert into employees values(null, 5, 'José', 'Arévalo', 'EmpleadoDesarrollo', sha2('pasword2', 256), null, 'DST', now(), null);



DELIMITER //
CREATE PROCEDURE sp_select_user (
    IN email VARCHAR(250),
    IN passwd VARCHAR(64))
BEGIN
IF ((Select count(*) from employees where employees.email = email and employees.passwd = sha2(passwd, 256)) = 1) THEN
SELECT e.id, r.rname as 'Rol', concat(e.fname, ' ', e.lname) as 'Nombre', e.email as 'Correo', e.chief as 'Superior', d.dname as 
'Departamento', NULL as 'Error' from roles r inner join employees e on r.id = e.rol inner join departments d on d.id = e.department where 
e.email = email and e.passwd = SHA2(passwd, 256); 
ELSEIF ((Select count(*) from employees where employees.email = email) = 0) THEN
SELECT NULL as 'id', NULL as 'Rol', NULL as 'Nombre', NULL as 'Correo', NULL as 'Superior', NULL as 'Departamento', 'No se encontró ningún usuario' as 'Error';
ELSE 
SELECT NULL as 'id', NULL as 'Rol', NULL as 'Nombre', NULL as 'Correo', NULL as 'Superior', NULL as 'Departamento', 'Contraseña incorrecta' as 'Error';
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
CREATE PROCEDURE sp_insert_department(IN id varchar(3), IN dname varchar(250))
BEGIN
	insert into departments values (id,dname);
END//
DELIMITER;

DELIMITER //
CREATE PROCEDURE sp_update_department(IN id varchar(3), IN dname varchar(250))
BEGIN
 UPDATE departments SET  departments.dname = dname
 where departments.id = id;
END //
DELIMITER;


DELIMITER //
CREATE PROCEDURE sp_select_users ()
BEGIN
SELECT e.id as 'ID', r.rname as 'Rol', e.id, e.fname as 'Nombres', e.lname as 'Apellidos', e.email as 'Correo', e.chief as 'Superior', 
d.dname as 'Departamento', e.created_at as 'Fecha de creacin', NULL as 'Error' from roles r inner join employees e on r.id = e.rol inner 
join departments d on d.id = e.department;
END//
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_select_boss_employees()
BEGIN
select employees.id ,concat(employees.fname ,' ' ,employees.lname) as 'Nombre Empleado', 
	employees.email, roles.rname, departments.dname from employees
    inner join roles on employees.rol = roles.id
    inner join departments on employees.department = departments.id
    where employees.rol in (select id from roles where rname like 'Jefe%');
END//
DELIMITER ;


DELIMITER //
CREATE PROCEDURE sp_insert_boss_employees(IN rol int, IN fname varchar(250), IN lname varchar(250),
										IN email varchar(250), IN pass varchar(64), IN chief int, 
                                        in department varchar(3))
BEGIN
insert into employees values(null, rol, fname, lname, email, sha2(pass, 256), chief, department, now(), null);
END//
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_update_boss_employees(in id int, IN rol int, IN fname varchar(250), IN lname varchar(250),
										IN email varchar(250), IN pass varchar(64), 
                                        in department varchar(3), IN mod_pass boolean) 
BEGIN
IF mod_pass = TRUE
then
update employees set
	employees.rol = rol,
    employees.fname = fname,
    employees.lname = lname,
    employees.email = email,
    employees.passwd = pass,
    employees.department = department,
    employees.passwd = sha2(pass,256),
    employees.updated_at = now()
    where employees.id = id;
else
update employees set
	employees.rol = rol,
    employees.fname = fname,
    employees.lname = lname,
    employees.email = email,
    employees.department = department,
    employees.updated_at = now()
    where employees.id = id;
END IF;
END//
DELIMITER ;

DELIMITER //
create procedure sp_select_latest_cases()
BEGIN
select c.id as Id, r.title as Titulo, concat(e.fname, ' ', e.lname) as CreadoPor, concat(e2.fname, ' ', e2.lname) as Asignado, DATE_FORMAT(c.deadline,'%d - %b - %Y') as Limite, 
c.percent as Avance, DATE_FORMAT(c.updated_at,'%d - %b - %Y') as UltimoCambio
from cases c 
inner join requests r on r.id = c.request
inner join employees e on r.created_by = e.id
inner join employees e2 on c.assigned_to = e2.id 
where c.case_status = 1 order by c.created_at limit 4; 
END //
DELIMITER ;
DELIMITER //
create procedure sp_select_back_case()
BEGIN
select c.id as Id, r.title as Titulo, concat(e.fname, ' ', e.lname) as CreadoPor, concat(e2.fname, ' ', e2.lname) as Asignado, DATE_FORMAT(c.deadline,'%d - %b - %Y') as Limite, 
c.percent as Avance, DATE_FORMAT(c.updated_at,'%d - %b - %Y') as UltimoCambio
from cases c 
inner join requests r on r.id = c.request
inner join employees e on r.created_by = e.id
inner join employees e2 on c.assigned_to = e2.id 
where c.case_status = 4 order by c.created_at desc limit 1; 
END //
DELIMITER ;
DELIMITER //
create procedure sp_select_to_accept_case()
BEGIN
select c.id as Id, r.title as Titulo, concat(e.fname, ' ', e.lname) as CreadoPor, concat(e2.fname, ' ', e2.lname) as Asignado, DATE_FORMAT(c.deadline,'%d - %b - %Y') as Limite, 
c.percent as Avance, DATE_FORMAT(c.updated_at,'%d - %b - %Y') as UltimoCambio
from cases c 
inner join requests r on r.id = c.request
inner join employees e on r.created_by = e.id
inner join employees e2 on c.assigned_to = e2.id 
where c.case_status = 2 order by c.created_at desc limit 1; 
END //
DELIMITER ;
DELIMITER //
create procedure sp_select_death_case()
BEGIN
select c.id as Id, r.title as Titulo, concat(e.fname, ' ', e.lname) as CreadoPor, concat(e2.fname, ' ', e2.lname) as Asignado, DATE_FORMAT(c.deadline,'%d - %b - %Y') as Limite, 
c.percent as Avance, DATE_FORMAT(c.updated_at,'%d - %b - %Y') as UltimoCambio
from cases c 
inner join requests r on r.id = c.request
inner join employees e on r.created_by = e.id
inner join employees e2 on c.assigned_to = e2.id 
where c.case_status = 3 order by c.created_at desc limit 1; 
END //
DELIMITER ;
DELIMITER //

DELIMITER //
CREATE PROCEDURE sp_view_request_no_description(IN department varchar(3))
BEGIN
select requests.id, requests.title, departments.dname, request_types.rt_name, request_status.rs_name from
requests inner join departments on requests.department = departments.id
inner join request_status on requests.request_status = request_status.id
inner join request_types on requests.request_type = request_types.id
where requests.department = department;
END //
DELIMITER ;


DELIMITER //
CREATE procedure sp_insert_request(IN request_type int, IN department_in varchar(255), IN title varchar(255), IN descript text,
									IN created_by int, in commentary text)
BEGIN
insert into requests(request_type, department, title, descrip, created_by, request_status, commentary) 
	values (request_type, (select departments.id from departments where departments.dname = department_in)
			,title, descript, created_by
			,(select request_status.id from request_status where request_status.rs_name like 'En espera de respuesta')
			,commentary);
                    
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_modify_request(IN request_id int, IN request_type int, IN title varchar(255), IN descript text,
								   in commentary text)
BEGIN
update requests set 
requests.request_type = request_type,
requests.title = title,
requests.descrip = descript,
requests.commentary = commentary,
requests.updated_at = now(),
requests.request_status = (select request_status.id from request_status where request_status.rs_name = 'En espera de respuesta')
where requests.id = request_id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_deny_request(IN request_id int, in commentary text)
BEGIN
update requests set 
requests.commentary = commentary,
requests.updated_at = now(),
requests.request_status = (select request_status.id from request_status where request_status.rs_name = 'Solicitud rechazada') 
where requests.id = request_id;
END //
DELIMITER ;

select * from requests;

call sp_deny_request(25852,'feo');

DELIMITER //
CREATE PROCEDURE sp_select_request(IN created_by_id int, IN department_in varchar(250))
BEGIN
select requests.id, requests.title, requests.descrip, departments.dname, request_types.rt_name, request_status.rs_name 
from requests inner join departments on requests.department = departments.id 
inner join request_types on requests.request_type = request_types.id
inner join request_status on requests.request_status = request_status.id
where requests.created_by = created_by_id or requests.department = (select departments.id from departments where departments.dname = department_in);
END //
DELIMITER ;


DELIMITER //
create procedure sp_select_individual_request(in id int, in created_by int)
BEGIN
select requests.id, request_types.rt_name, departments.dname, requests.title, requests.descrip, 
concat(employees.fname, ' ' , employees.lname) as 'Creado por',
request_status.rs_name, requests.commentary, requests.created_at, requests.updated_at 
from requests inner join request_types on requests.request_type = request_types.id inner join
request_status on requests.request_status = request_status.id inner join
employees on requests.created_by = employees.id inner join 
departments on requests.department = departments.id
where requests.id = id and requests.created_by = created_by;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_delete_request(IN request_id int)
BEGIN
if (select count(cases.request) from cases where cases.request = request_id) = 0
then
delete from requests where requests.id = request_id;
END IF;
END //
DELIMITER ;

DELIMITER //
create procedure sp_select_finalized_case()
BEGIN
select c.id as Id, r.title as Titulo, concat(e.fname, ' ', e.lname) as CreadoPor, concat(e2.fname, ' ', e2.lname) as Asignado, DATE_FORMAT(c.deadline,'%d - %b - %Y') as Limite, 
c.percent as Avance, DATE_FORMAT(c.updated_at,'%d - %b - %Y') as UltimoCambio
from cases c 
inner join requests r on r.id = c.request
inner join employees e on r.created_by = e.id
inner join employees e2 on c.assigned_to = e2.id 
where c.case_status = 5 order by c.created_at desc limit 1; 
END //
DELIMITER ;