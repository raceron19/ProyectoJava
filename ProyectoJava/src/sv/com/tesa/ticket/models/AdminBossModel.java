/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import sv.com.tesa.ticket.utils.Utilidades;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.EmployeeBean;
import org.apache.log4j.Logger;

/**
 *
 * @author Edu
 */
public class AdminBossModel extends LoginModel{
    
    private JTable tabla;
    
    
    public JTable listarEmpleados()
    {
        try {
            String sql = "call sp_select_employees()";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            
            if (resultado) {
                rs = st.getResultSet();
                String[] col = {"Id","Nombre Empleado","Correo","Cargo","Departamento"};
                tabla = Utilidades.cargarTabla(col, rs);
            }
            else
            {
                tabla = null;
            }
            this.desconectar();
            return tabla;
        } catch (SQLException e) {
            Logger.getLogger(AdminBossModel.class).error("Error al listar jefes en JTable listarJefes",e);
            return null;
        }
    }
    
    public boolean modificarJefe(EmployeeBean beanEmpleado, boolean op)
    {
         try {
            String sql = "CALL sp_update_boss_employees(?,?,?,?,?,?,?,?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, beanEmpleado.getId());
            st.setInt(2, beanEmpleado.getRol());
            st.setString(3, beanEmpleado.getNombre());
            st.setString(4, beanEmpleado.getApellido());
            st.setString(5, beanEmpleado.getEmail());
            st.setString(6, beanEmpleado.getPassword());
            st.setString(7, beanEmpleado.getDepartamento());
            st.setBoolean(8, op);
            st.setInt(9, beanEmpleado.getJefe());
            
            int resultado = st.executeUpdate();
            this.desconectar();
            return resultado > 0;
        } catch (SQLException e) {
            Logger.getLogger(AdminBossModel.class).error("Error al modificar "
                    + "jefes en función modificarJefe",e);
            return false;
        }
    }
    
    public HashMap<Integer, String> listarRoles()
    {
        HashMap<Integer, String> map = new HashMap<>();
        try {
            String sql = "CALL sp_select_roles()";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs  = st.executeQuery();
            while(rs.next())
            {
                map.put(rs.getInt("id"), rs.getString("rol"));
            }
            this.desconectar();
            return map;
        } catch (SQLException e) 
        {
            Logger.getLogger(AdminBossModel.class).error("Error al listar "
                    + "roles en función listarRoles",e);
            return null;
        }
    }
    
    public HashMap<String, String> listarDepartamentos()
    {
        HashMap<String, String> map = new HashMap<>();
        try {
            String sql = "CALL sp_select_departments()";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs  = st.executeQuery();    
            while(rs.next())
            {
                map.put(rs.getString("id"), rs.getString("departamento"));
            }
            this.desconectar();
            return map;
        } catch (SQLException e) 
        {
            Logger.getLogger(AdminBossModel.class).error("Error al listar "
                    + "roles en función listarDepartamentos",e);
            return null;
        }
    }
    
    public boolean ingresarEmpleado (EmployeeBean empleado)
    {
        try {
            String sql = "CALL sp_insert_new_employee(?,?,?,?,?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, empleado.getRol());
            st.setString(2, empleado.getNombre());
            st.setString(3, empleado.getApellido());
            st.setString(4, empleado.getEmail());
            st.setInt(5, empleado.getJefe());
            st.setString(6, empleado.getDepartamento());
            
            int res = st.executeUpdate();
            this.desconectar();
            return res > 0;
        } catch (SQLException e) {
            Logger.getLogger(AdminBossModel.class).error("Error en AdminBossModel al ingresar "
                    + "empleado en función ingresarEmpleado",e);
            return false;
        }
    }
    
    public HashMap<Integer,String> listarJefes()
    {
        HashMap<Integer, String> map = new HashMap<>();
        try {
            String sql = "CALL sp_select_boss_employees()";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs  = st.executeQuery();    
            while(rs.next())
            {
                map.put(rs.getInt(1), rs.getString(2));
            }
            this.desconectar();
            return map;
        } catch (SQLException e) 
        {
            Logger.getLogger(AdminBossModel.class).error("Error al listar "
                    + "jefes en función listarDepartamentos",e);
            return null;
        }
    }
    
}
