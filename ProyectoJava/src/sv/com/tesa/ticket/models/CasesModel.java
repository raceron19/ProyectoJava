/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import static sv.com.tesa.ticket.models.ConexionModel.conexion;
import sv.com.tesa.ticket.utils.Utilidades;

/**
 *
 * @author eduar
 */
public class CasesModel extends ConexionModel{
 private JTable tabla;
    public JTable listarCasos(){
        try{
            String sql = "SELECT cases.id AS IdCaso, requests.title AS Caso, cases.descrip AS Descripcion, cases.percent AS porcentaje, " +
                         "concat(tester.fname,' ',tester.lname) AS Tester, asign.fname AS Asignado, case_status.cs_name AS Estado, cases.deadline AS Finalizacion " +
                         "from cases\n" +
                         "INNER JOIN requests ON cases.request = requests.id " +
                         "INNER JOIN employees AS tester ON cases.tester = tester.id " +
                         "INNER JOIN employees AS asign ON cases.assigned_to = asign.id " +
                         "INNER JOIN case_status ON cases.case_status = case_status.id "
                         + "where tester.department = (select id from departments where dname = '" + LoginBean.getDepartamento() + "')";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            
            if(resultado){
                rs = st.getResultSet();
                String[] col = {"IdCaso", "Caso", "Descripcion", "Porcentaje", "Tester", "Asignado", "Estado", "Fecha_Finalizacion"};
                tabla = Utilidades.cargarTabla(col, rs);
            }
            else{
                tabla = null;
            }
            this.desconectar();
            return tabla;
        }catch(Exception ex){
            Logger.getLogger(RecentCasesModel.class).error("Error al listar " + "casos en funcion listarCasos", ex);
            return null;
        }
    }
    
   public SingleCaseBean listarCaso(SingleCaseBean beanCase){
        try{
            String sql = "SELECT cases.id AS IdCaso, requests.title AS Caso, cases.descrip AS Descripcion, cases.percent AS porcentaje, " +
                         "concat(tester.fname,' ',tester.lname) AS Tester, concat(asign.fname,' ',tester.lname) AS Asignado, case_status.cs_name AS Estado,"
                         + " cases.created_at AS Creado, cases.updated_at AS Modificacion, cases.deadline AS Finalizacion " +
                         "from cases " +
                         "INNER JOIN requests ON cases.request = requests.id " +
                         "INNER JOIN employees AS tester ON cases.tester = tester.id " +
                         "INNER JOIN employees AS asign ON cases.assigned_to = asign.id " +
                         "INNER JOIN case_status ON cases.case_status = case_status.id"
                         + " WHERE cases.id = ?";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setString(1, String.valueOf(beanCase.getId()));
            rs = st.executeQuery();
            SingleCaseBean peticionIndividual = new SingleCaseBean();
            while(rs.next()){
                peticionIndividual.setId(rs.getString("IdCaso"));
                peticionIndividual.setTitulo(rs.getString("Caso"));
                peticionIndividual.setAsignadoA(rs.getString("Asignado"));
                peticionIndividual.setEstado(rs.getString("Estado"));;
                peticionIndividual.setDescripcion(rs.getString("Descripcion"));
                peticionIndividual.setAvance(Double.parseDouble(rs.getString("porcentaje")));
                peticionIndividual.setTester(rs.getString("Tester"));
                peticionIndividual.setFechaCreacion(rs.getString("Creado"));
                peticionIndividual.setUltimoCambio(rs.getString("Modificacion"));
                peticionIndividual.setLimite(rs.getString("Finalizacion"));
            }
            this.desconectar();
            return peticionIndividual;
        }catch(SQLException ex){
            System.out.println("Error en RequestModel CasoIndividual " + 
                    ex.getSQLState() + " " + ex.getMessage());
            return null;
        }
    }
   
   public boolean modificarCasoJefeDesarrollo(SingleCaseBean beanCase){
       try{
           JOptionPane.showMessageDialog(null,"Entre al modelo");
           String sql = "call sp_update_cases(?,?,?)";
           this.conectar();
           st = conexion.prepareCall(sql);
           st.setInt(1, Integer.parseInt(beanCase.getAsignadoA()));
           st.setString(2, beanCase.getDescripcion());
           st.setString(3, beanCase.getId());
           int resultado = st.executeUpdate();            
            if (resultado > 0) {
                this.desconectar();
                return true;
            }
            this.desconectar();
            return false;
       }catch(Exception ex){
           Logger.getLogger(AdminDeptModel.class).error("Error al actualizar "
                    + "casos en función modificarCasoJefeDesarrollo",ex);
            return false;
       }
   }
   
   public boolean modificarCasoJefeAreaFuncional(SingleCaseBean beanCase){
       try{
           JOptionPane.showMessageDialog(null, "entre al model");
           String sql = "call sp_update_cases_JAF(?,?)";
           this.conectar();
           st = conexion.prepareCall(sql);
           st.setInt(1, Integer.parseInt(beanCase.getTester()));
           st.setString(2, beanCase.getId());
           int resultado = st.executeUpdate();            
            if (resultado > 0) {
                this.desconectar();
                return true;
            }
            this.desconectar();
            return false;
       }catch(Exception ex){
           Logger.getLogger(AdminDeptModel.class).error("Error al actualizar "
                    + "casos en función modificarCasoJefeAreaFuncional",ex);
            return false;
       }
   }
   
   public HashMap<Integer,String> listarEmpleadosACargo()
    {
        HashMap<Integer, String> map = new HashMap<>();
        try {
            String sql = "call sp_select_employees_chief(?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setInt(1, LoginBean.getId());
            rs = st.executeQuery();
            
            while(rs.next())
            {
                map.put(rs.getInt(1), rs.getString(2));
            }
            this.desconectar();
            return map;
        } catch (SQLException e) {
            Logger.getLogger(CasesModel.class).error("Error al listar "
                    + "empleados a cargo en CasesModel función listarEmpleadosACargo",e);
             return null;
        }
    }
}
