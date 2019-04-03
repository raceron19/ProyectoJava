/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import org.apache.log4j.Logger;
import sv.com.tesa.ticket.beans.BinnaclesBean;
import sv.com.tesa.ticket.beans.RecentCasesBean;
import static sv.com.tesa.ticket.models.ConexionModel.conexion;
import sv.com.tesa.ticket.utils.Utilidades;

/**
 *
 * @author vaselinux
 */
public class BinnaclesModel extends ConexionModel{
    
    public JTable getBinnacles(String idCase)
    {
        List<BinnaclesBean> lista= new ArrayList<>();
        try {
            String sql = "CALL  sp_select_binnacle_cases(?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, idCase);
            rs = st.executeQuery();
            rs = st.getResultSet();
            String[] col={"Id","Caso Numero","Comentario","Fecha"};
            JTable tabla = Utilidades.cargarTabla(col, rs);
            
            return tabla;
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
    
    public void insertBinnacle(){
        
        try {
            String sql = "CALL  sp_insert_binnacle_cases(?)";
            this.conectar();
            
            st = conexion.prepareStatement(sql);
            //st.setString(1, idCase);
            rs = st.executeQuery();
            rs = st.getResultSet();
            String[] col={"Id","Caso Numero","Comentario","Fecha"};
            JTable tabla = Utilidades.cargarTabla(col, rs);
            //return tabla;
        } catch (SQLException ex) {
            Logger.getLogger(RecentCasesModel.class).error("Error al obtener los datos",ex);
            //return null;
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
