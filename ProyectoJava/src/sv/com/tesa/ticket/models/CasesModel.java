package sv.com.tesa.ticket.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.CasesBean;
import sv.com.tesa.ticket.utils.Utilidades;

public class CasesModel extends ConexionModel{
    private JTable tabla;
    
    public JTable listarCasos(){
        try{
            String sql = "SELECT cases.id AS IdCaso, requests.title AS Caso, cases.descrip AS Descripcion, cases.percent AS porcentaje, " +
                         "tester.fname AS Tester, asign.fname AS Asignado, case_status.cs_name AS Estado " +
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
            Logger.getLogger(CasesModel.class).error("Error al listar " + "casos en funcion listarCasos", ex);
            return null;
        }
    }
    
    public ResultSet llenarRequest() throws SQLException{
        try{
            String sql = "SELECT * FROM requests";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            if(resultado){
                rs = st.getResultSet();                
            }
            else{
                rs = null;
            }
            return rs;
        }
        catch(Exception ex){
            Logger.getLogger(CasesModel.class).error("Error al listar " + "requests: ", ex);
            return null;
        }
        
        
    }
    public ResultSet llenarAsigned() throws SQLException{
        try{
            String sql = "SELECT * FROM employees";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            if(resultado){
                rs = st.getResultSet();                
            }
            else{
                rs = null;
            }
            return rs;
        }
        catch(Exception ex){
            Logger.getLogger(CasesModel.class).error("Error al listar " + "requests: ", ex);
            return null;
        }
        
        
    }
    public ResultSet llenarTester() throws SQLException{
        try{
            String sql = "SELECT * FROM employees";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            if(resultado){
                rs = st.getResultSet();                
            }
            else{
                rs = null;
            }
            return rs;
        }
        catch(Exception ex){
            Logger.getLogger(CasesModel.class).error("Error al listar " + "requests: ", ex);
            return null;
        } 
    }
    public ResultSet llenarEstado() throws SQLException{
        try{
            String sql = "SELECT * FROM case_status";
            this.conectar();
            st = conexion.prepareCall(sql);
            boolean resultado = st.execute();
            if(resultado){
                rs = st.getResultSet();                
            }
            else{
                rs = null;
            }
            return rs;
        }
        catch(Exception ex){
            Logger.getLogger(CasesModel.class).error("Error al listar " + "requests: ", ex);
            return null;
        } 
    }
}
