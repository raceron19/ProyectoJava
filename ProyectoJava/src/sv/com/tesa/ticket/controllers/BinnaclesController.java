/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import java.util.List;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.BinnaclesBean;
import sv.com.tesa.ticket.models.BinnaclesModel;

/**
 *
 * @author vaselinux
 */
public class BinnaclesController {
    
    private BinnaclesModel model;
    //= new BinnaclesModel();
    public JTable mostrarTabla(String idCase){
        return model.getBinnacles(idCase);
    }
    
    public void newBinnacle(String idCase, String percent){
        
    
    }
    
}
