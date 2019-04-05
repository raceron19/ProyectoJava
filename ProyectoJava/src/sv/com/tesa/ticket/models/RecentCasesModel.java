/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.utils.Utilidades;
import java.sql.SQLException;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import sv.com.tesa.ticket.beans.SingleCaseBean;
import sv.com.tesa.ticket.beans.SingleRequestBean;
import static sv.com.tesa.ticket.models.ConexionModel.conexion;

/**
 *
 * @author eduar
 */
public class RecentCasesModel extends ConexionModel
{
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
        }catch(Exception ex){
            Logger.getLogger(RecentCasesModel.class).error("Error al listar " + "casos en funcion listarCasos", ex);
            return null;
        }
    }
    
   public SingleCaseBean listarCaso(RecentCasesBean beanCase){
        try{
            String sql = "SELECT cases.id AS IdCaso, requests.title AS Caso, cases.descrip AS Descripcion, cases.percent AS porcentaje, " +
                         "concat(tester.fname,' ',tester.lname) AS Tester, concat(asign.fname,' ',tester.lname) AS Asignado, case_status.cs_name AS Estado,"
                         + " cases.created_at AS Creado, cases.updated_at AS Modificacion " +
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
            }
            this.desconectar();
            return peticionIndividual;
        }catch(SQLException ex){
            System.out.println("Error en RequestModel CasoIndividual " + 
                    ex.getSQLState() + " " + ex.getMessage());
            return null;
        }
    }
    public RecentCasesBean [] recientes()
    {
        RecentCasesBean [] latestCasesArray = new RecentCasesBean[5];
        RecentCasesBean latestCases = new RecentCasesBean();
        try {
            String sql = "CALL sp_select_latest_cases()";
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next())
            {
                    latestCases.setId(rs.getString("Id"));
                    latestCases.setTitulo(rs.getString("Titulo"));
                    latestCases.setCreadoPor(rs.getString("CreadoPor"));
                    latestCases.setAsignadoA(rs.getString("Asignado"));
                    latestCases.setLimite(rs.getString("Limite"));
                    latestCases.setAvance(rs.getDouble("Avance"));
                    if(rs.getString("UltimoCambio") == null)
                    {
                        latestCases.setUltimoCambio("No hay avances");
                    }
                    else
                    {
                        latestCases.setUltimoCambio(rs.getString("UltimoCambio"));
                    }
                    latestCasesArray[rs.getRow() -1] = latestCases;
            }
            return latestCasesArray;
        } catch (SQLException ex) {
            Logger.getLogger(RecentCasesModel.class).error("Error al obtener los datos",ex);
            return latestCasesArray;
        }
        finally
        {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(RecentCasesModel.class).error("Error al cerrar la conexiòn.",ex);
            }
        }
    }

    public RecentCasesBean otherCases(String tipo)
    {
        RecentCasesBean latestCases = new RecentCasesBean();
        String sql = "";
        try {
            switch (tipo) {
                case "Finalizado":
                    sql = "CALL sp_select_finalized_case()";
                    break;
                case "Aprobar":
                    sql = "CALL sp_select_to_accept_case()";
                    break;
                case "Vencido":
                    sql = "CALL sp_select_death_case()";
                    break;
                case "Devuelto":
                    sql = "CALL sp_select_back_case()";
                    break;
                default:
                    throw new AssertionError();
            }
            this.conectar();
            st = conexion.prepareStatement(sql);
            rs = st.executeQuery();
            while(rs.next())
            {
                    latestCases.setId(rs.getString("Id"));
                    latestCases.setTitulo(rs.getString("Titulo"));
                    latestCases.setCreadoPor(rs.getString("CreadoPor"));
                    latestCases.setAsignadoA(rs.getString("Asignado"));
                    latestCases.setLimite(rs.getString("Limite"));
                    latestCases.setAvance(rs.getDouble("Avance"));
                    if(rs.getString("UltimoCambio") == null)
                    {
                        latestCases.setUltimoCambio("No hay avances");
                    }
                    else
                    {
                        latestCases.setUltimoCambio(rs.getString("UltimoCambio"));
                    }
            }
            return latestCases;
        } catch (SQLException ex) {
            Logger.getLogger(RecentCasesModel.class).error("Error al obtener los datos",ex);
            return null;
        }
        finally
        {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(RecentCasesModel.class).error("Error al cerrar la conexiòn.",ex);
            }
        }
    }
}
