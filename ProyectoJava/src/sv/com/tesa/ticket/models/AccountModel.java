/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.EmployeeBean;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import static sv.com.tesa.ticket.models.ConexionModel.conexion;

/**
 *
 * @author Rodrigo
 */
public class AccountModel extends ConexionModel{
    public EmployeeBean cuenta(LoginBean logOn)
    {
        
        EmployeeBean employee = new EmployeeBean();
        try {
            String sql = "CALL sp_get_employee()";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, String.valueOf(logOn.getId()));
            rs = st.executeQuery();
            rs.first();
            employee.setId(Integer.valueOf(rs.getString("id")));
            employee.setRol(Integer.valueOf(rs.getString("rol")));
            employee.setNombre(rs.getString("nombre"));
            employee.setApellido(rs.getString("apellido"));
            employee.setEmail(rs.getString("email"));
            employee.setPassword(rs.getString("password"));
            employee.setJefe(Integer.valueOf(rs.getString("chief")));
            employee.setDepartamento(rs.getString("department"));
            
            return employee;
        } catch (SQLException ex) {
            Logger.getLogger(AccountModel.class).error("Error al obtener los datos",ex);
            return employee;
        }
        finally
        {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(AccountModel.class).error("Error al cerrar la conexiòn.",ex);
            }
        }
    }
}
