drop PROCEDURE sp_get_employee;

DELIMITER //
CREATE PROCEDURE sp_get_employee(IN id varchar(3))
BEGIN
 select e.id, e.rol, concat(employees.fname ,' ' ,employees.lname) as 'nombre', e.email, e.passwd, e.chief, e.department from employees e 
 where e.id = id;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_update_employeePass(IN id varchar(3), IN newPass varchar(64))
BEGIN
 UPDATE employees SET  employees.passwd = newPass
 where employees.id = id;
END //
DELIMITER ;