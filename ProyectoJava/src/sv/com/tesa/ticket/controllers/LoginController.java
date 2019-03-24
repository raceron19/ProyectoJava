/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import sv.com.tesa.ticket.models.LoginModel;

import sv.com.tesa.ticket.beans.LoginBean;
/**
 *
 * @author Edu
 */


public class LoginController {
    public static LoginBean validarUsuario(String user, String password){
        LoginModel loginM = new LoginModel();
        LoginBean loginB = loginM.validar(user, password);
        return loginB;
    }
    
    public static Boolean esLoginExitoso(LoginBean logUser)
    {
        return logUser.getError() == null;
    }
}
