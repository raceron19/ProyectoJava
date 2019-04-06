/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import javax.swing.JTable;
import org.apache.log4j.Logger;
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
                         "concat(tester.fname,' ',tester.lname) AS Tester, asign.fname AS Asignado, case_status.cs_name AS Estado " +
                         "from cases\n" +
                         "INNER JOIN requests ON cases.request = requests.id " +
                         "INNER JOIN employees AS tester ON cases.tester = tester.id " +
                         "INNER JOIN employees AS asign ON cases.assigned_to = asign.id " +
                         "INNER JOIN case_status ON cases.case_status = case_status.id";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            
            if(resultado){
                rs = st.getResultSet();
                String[] col = {"IdCaso", "Caso", "Descripcion", "Porcentaje", "Tester", "Asignado", "Estado"};
                tabla = Utilidades.cargarTabla(col, rs);
            }
            else{
                tabla = null;
            }
            this.desconectar();
            return tabla;
        }catch(SQLException ex){
            Logger.getLogger(RecentCasesModel.class).error("Error al listar " + "casos en funcion listarCasos", ex);
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
            System.out.println("Error en RequestModel CasoIndividual " + 
                    ex.getSQLState() + " " + ex.getMessage());
            return null;
        }
    }   
}
