/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.utils;

import java.awt.BorderLayout;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;
import org.jdatepicker.*;

/**
 *
 * @author vaselinux
 */
public class Utilidades {
    
    private static DefaultTableModel modeloTabla;
    private static DatePicker picker;
    private static JDatePanel auxPanel;
    
    public static JTable cargarTabla(String[] columnas,ResultSet rs) throws SQLException{
        try {
            modeloTabla = new DefaultTableModel(null,columnas){
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
            
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
        } catch (SQLException e) {
            Logger.getLogger(Utilidades.class).error("Error al cargar tabla en funciòn cargarTable ",e);
            return null;
        }
    }
    
    public static Object regresarValorHashMap(HashMap map, String valor)
    {
        for (Object o : map.keySet()) {
            if(map.get(o).equals(valor))
                return o;
        }
        return null;
    }
    
    public static String generarNumAleatorio()
    {
        Random ale = new Random();
        int numero = ale.nextInt(1000);
        return String.format("%03d", numero);
    }
    
    public static JPanel opcionFecha()
    {
        picker = new JDatePicker();
        picker.setTextEditable(true);
        picker.setShowYearButtons(true);
        JPanel jPanel = new JPanel();
        jPanel.add((JComponent) picker);
        JPanel datePanel = new JPanel();
        datePanel.setLayout(new BorderLayout());
        datePanel.add(jPanel, BorderLayout.WEST);
        return datePanel;
    }
    
    public static String regresarFecha()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Calendar cal = (Calendar) picker.getModel().getValue();
        
        return (cal != null ? sdf.format(cal.getTime()) : null);
    }
    
    
}
