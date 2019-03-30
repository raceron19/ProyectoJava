/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vaselinux
 */
public class Utilidades {
    
    private static DefaultTableModel modeloTabla;
    
    public static JTable cargarTabla(String[] columnas,ResultSet rs) throws SQLException{
        try {
            modeloTabla = new DefaultTableModel(null,columnas);
            ResultSetMetaData rsmd = rs.getMetaData();
            int cantidadColumnas = rsmd.getColumnCount();
            Object datos[] = new Object[cantidadColumnas];
            while(rs.next()){//recorrer registros
                for(int i=0;i<cantidadColumnas;i++){ //cargar datos
                    datos[i]=rs.getString(i+1);
                }
                modeloTabla.addRow(datos);

            }
            JTable tabla = new JTable(modeloTabla);
            tabla.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            return tabla;
        } catch (Exception e) {
            return null;
        }
    }
    
}
