/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.CaseBean;
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
            st = conexion.prepareStatement(sql);
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
            Logger.getLogger(CasesModel.class).error("Error al listar "
                    + "casos en CasesModel función listarCasos",ex);
            return null;
        }
    }
    
 @SuppressWarnings("empty-statement")
   public SingleCaseBean listarCaso(SingleCaseBean beanCase){
        try{
            String sql = "SELECT c.id AS IdCaso, r.title AS Caso, c.descrip AS Descripcion, c.percent AS porcentaje, " +
                "concat(t.fname, ' ', t.lname) AS Tester, concat(a.fname, ' ', a.lname) AS Asignado, cs.cs_name AS Estado," +
                " DATE_FORMAT(c.created_at,'%W - %M - %Y - %h:%i:%s') AS Creado, DATE_FORMAT(c.updated_at,'%W - %M - %Y - %h:%i:%s') " + 
                "AS Modificacion, concat(cp.fname, ' ', cp.lname) as CreadoPor, " +
                "DATE_FORMAT(c.deadline,'%W - %M - %Y - %h:%i:%s') as FechaLimite, " +
                "DATE_FORMAT(c.to_production,'%W - %M - %Y - %h:%i:%s') as Aproduccion from cases c " +
                "INNER JOIN requests r ON c.request = r.id " +
                "INNER JOIN employees t ON c.tester = t.id " +
                "INNER JOIN employees a ON c.assigned_to = a.id " +
                "INNER JOIN case_status cs ON c.case_status = cs.id " + 
                "INNER JOIN employees cp ON r.created_by = cp.id" + 
                " WHERE c.id = ?";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, String.valueOf(beanCase.getId()));
            rs = st.executeQuery();
            SingleCaseBean peticionIndividual = new SingleCaseBean();
            while(rs.next()){
                peticionIndividual.setId(rs.getString("IdCaso"));
                peticionIndividual.setTitulo(rs.getString("Caso"));
                peticionIndividual.setAsignadoA(rs.getString("Asignado"));
                peticionIndividual.setEstado(rs.getString("Estado"));;
                peticionIndividual.setDescripcion(rs.getString("Descripcion"));
                peticionIndividual.setAvance(rs.getDouble("porcentaje"));
                peticionIndividual.setTester(rs.getString("Tester"));
                peticionIndividual.setFechaCreacion(rs.getString("Creado"));
                peticionIndividual.setUltimoCambio(rs.getString("Modificacion"));
                peticionIndividual.setCreadoPor(rs.getString("CreadoPor"));
                peticionIndividual.setLimite(rs.getString("FechaLimite"));
                peticionIndividual.setProduccion(rs.getString("AProduccion"));
            }
            this.desconectar();
            return peticionIndividual;
        }catch(SQLException ex){
            Logger.getLogger(CasesModel.class).error("Error al listar "
                    + "caso individual en CasesModel función listarCaso",ex);
            return null;
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
    
    public boolean ingresarCaso(CaseBean caso)
    {
        try {
            String sql = "call sp_insert_new_case(?,?,?,?,?,?)";
            this.conectar();
            st = conexion.prepareCall(sql);
            st.setString(1, caso.getDepartamento());
            st.setString(2, caso.getId());
            st.setInt(3, caso.getIdSolicitud());
            st.setInt(4, caso.getEmpleadoAsignado());
            DateFormat formato = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            Date parsedDate = formato.parse(caso.getFechaLimite());
            Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
            st.setTimestamp(5, timestamp);
            st.setString(6, caso.getDescripcion());
            
            int resultado = st.executeUpdate();
            this.desconectar();
            return resultado > 0;
            
        } catch (SQLException | ParseException e) {
            Logger.getLogger(CasesModel.class).error("Error al ingresar "
                    + "un caso en CasesModel función IngresarCaso",e);
            return false;
        }
    }
    public boolean reOpenCase(String caseId)
    {
     try {
         String sql = "CALL sp_re_open_case(?)";
         this.conectar();
         st = conexion.prepareStatement(sql);
         st.setString(1, caseId);
         return st.executeUpdate() > 0;
     }
     catch (SQLException ex) {
         Logger.getLogger(CasesModel.class.getName()).log( null, ex);
     }
     return false;
    }
}
