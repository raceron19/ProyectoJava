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

/**
 *
 * @author Edu
 */
public class AdminBossModel extends LoginModel{
    
    private JTable tabla;
    
    
    public JTable listarJefes()
    {
        try {
            String sql = "call sp_select_boss_employees()";
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
            System.out.println("Error Modelo Jefe: " + e.getSQLState() + " " + e.getMessage());
            return null;
        }
    }
    
    public boolean ingresarJefe(EmployeeBean beanEmpleado)
    {
        try {
            String sql = "CALL sp_insert_employees(?,?,?,?,?,?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, beanEmpleado.getRol());
            st.setString(2, beanEmpleado.getNombre());
            st.setString(3, beanEmpleado.getApellido());
            st.setString(4, beanEmpleado.getEmail());
            st.setString(5, beanEmpleado.getPassword());
            st.setNull(6, Types.NULL);
            st.setString(7,beanEmpleado.getDepartamento());
            
            int resultado = st.executeUpdate();
            this.desconectar();
            
            if (resultado > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean modificarJefe(EmployeeBean beanEmpleado, boolean op)
    {
         try {
            String sql = "CALL sp_update_boss_employees(?,?,?,?,?,?,?,?)";
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
            
            int resultado = st.executeUpdate();
            this.desconectar();
            
            if (resultado > 0) {
                return true;
            }
            return false;
        } catch (SQLException e) {
             System.out.println(e.getSQLState() + " " + e.getMessage());
            return false;
        }
    }
    
    public HashMap<Integer, String> listarRoles()
    {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        try {
            String sql = "select * from roles where rname like 'Jefe%' or 'jefe%'";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs  = st.executeQuery();
            while(rs.next())
            {
                map.put(rs.getInt("id"), rs.getString("rname"));
            }
            return map;
        } catch (SQLException e) 
        {
            return null;
        }
    }
    
    public HashMap<String, String> listarDepartamentos()
    {
        HashMap<String, String> map = new HashMap<String, String>();
        try {
            String sql = "select * from departments";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs  = st.executeQuery();
            while(rs.next())
            {
                map.put(rs.getString("id"), rs.getString("dname"));
            }
            return map;
        } catch (SQLException e) 
        {
            return null;
        }
    }
    
    
}
