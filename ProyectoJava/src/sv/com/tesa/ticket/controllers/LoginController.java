/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.com.tesa.ticket.models.Conexion;

/**
 *
 * @author vaselinux
 */
public class LoginController {
    private String email;
    private String passwd;

    public LoginController() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public void logUsuario(){
        Connection con= Conexion.conectar();
        
        try {
            
            CallableStatement cst = con.prepareCall("CALL validarusuario(?,?,?)");
            cst.setString(1, email);
            cst.setString(2, passwd);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.execute();
            int cantidad=cst.getInt(3);
            System.out.println(cantidad);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
}
