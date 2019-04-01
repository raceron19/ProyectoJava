/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import java.util.HashMap;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.beans.RequestBean;
import sv.com.tesa.ticket.models.RequestModel;
/**
 *
 * @author Edu
 */
public class RequestController {
    
    private RequestModel peticionModel;
    
    public RequestController()
    {
        peticionModel = new RequestModel();
    }
    
    public boolean ingresarPeticion(RequestBean peticion)
    {
        try {
            return peticionModel.ingresarPeticion(peticion);
        } catch (Exception e) {
            return false;
        }
    }
    
    public HashMap<Integer, String> listarTiposPeticion()
    {
        try {
            return peticionModel.listarTiposPeticion();
        } catch (Exception e) {
            return null;
        }
    }
    
    public JTable listarPeticiones(LoginBean usuario)
    {
        try {
            return peticionModel.listarPeticiones(usuario);
        } catch (Exception e) {
            return null;
        }
    }
}
