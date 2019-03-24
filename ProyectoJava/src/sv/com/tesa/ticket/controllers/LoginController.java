/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.models.LoginModel;

/**
 *
 * @author vaselinux
 */
public class LoginController {
    public void validarUsuario(String user, String password){
        LoginModel loginM = new LoginModel();
        LoginBean loginB = new LoginBean();
        loginB = loginM.validar(user, password);
    
    }
    
    
}
