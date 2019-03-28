/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;
import java.sql.SQLException;
import javax.swing.JTable;
import sv.com.tesa.ticket.utils.Utilidades;
import sv.com.tesa.ticket.beans.DepartmentBean;

/**
 *
 * @author Edu
 */
public class AdminDeptModel extends ConexionModel {
  
    private JTable tabla;
    
    public JTable listarDept()
    {
        try {
            String sql = "CALL sp_select_departments()";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            
            if (resultado) {
                rs = st.getResultSet();
                String[] col = {"ID Departamento","Departamento"};
                tabla = Utilidades.cargarTabla(col, rs);
            }
            else
            {
                tabla = null;
            }
            this.desconectar();
            return tabla;
            //this.desconectar();
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean ingresarDept(DepartmentBean beanDept)
    {
        try {
            String sql = "call sp_insert_department(?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setString(1, beanDept.getId());
            st.setString(2, beanDept.getNombreDept());
            int resultado = st.executeUpdate();
            
            if (resultado > 0) {
                this.desconectar();
                return true;
            }
            this.desconectar();
            return false;
        } catch (SQLException e) 
        {
            System.out.println("Error modelo Dept: " + e.getSQLState() + " " + e.getMessage());
            return false;
        }
    }
    
    public boolean modificarDept(DepartmentBean beanDept)
    {
        try {
            String sql = "call sp_update_department(?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setString(1, beanDept.getId());
            st.setString(2, beanDept.getNombreDept());
            int resultado = st.executeUpdate();
            
            if (resultado > 0) {
                this.desconectar();
                return true;
            }
            this.desconectar();
            return false;
        } catch (SQLException e) 
        {
            System.out.println("Error modelo Dept: " + e.getSQLState() + " " + e.getMessage());
            return false;
        }
    }
}
