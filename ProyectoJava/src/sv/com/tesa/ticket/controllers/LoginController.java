/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import sv.com.tesa.ticket.models.LoginModel;
import sv.com.tesa.ticket.beans.LoginBean;
import sv.com.tesa.ticket.utils.Validaciones;
/**
 *
 * @author Edu
 */


public class LoginController {
    
    public static LoginBean validarUsuario(String user, String password, JFrame frame){
        if(Validaciones.esCorreoElectronico(user))
        {
        LoginModel loginM = new LoginModel();
        return loginM.validar(user, password);
        }
        else
        {
            JOptionPane.showMessageDialog(frame, "Debe ingresar un email válido");
        }
        return null;
    }
    public static Boolean esLoginExitoso(LoginBean logUser)
    {
        return logUser.getError() == null;
    }
}
