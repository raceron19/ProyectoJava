/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import sv.com.tesa.ticket.beans.LoginBean;

/**
 *
 * @author vaselinux
 */
public class LoginModel {
    
    private LoginBean logInUsuario;
    private ConexionModel conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public LoginModel()
    {
        logInUsuario = new LoginBean();
        ps = null;
        rs = null;
    }
    
    public LoginBean logInUser(String correo, String contraseña)
    {
        try {
            conn = new ConexionModel();
            logInUsuario.setContraseña(contraseña);
            logInUsuario.setCorreo(correo);
            ps = conn.connect.prepareStatement("CALL sp_select_user(?,?)");
            ps.setString(1, logInUsuario.getCorreo());
            ps.setString(2,logInUsuario.getContraseña());
            conn.setRs(ps);
            rs = conn.getRs();
            rs.next();
            
            logInUsuario.setError(rs.getString("Error"));;
            if (logInUsuario.getError() == null) {
                
                logInUsuario.setId(rs.getInt("id"));
                logInUsuario.setRol(rs.getString("Rol"));
                logInUsuario.setNombre(rs.getString("Nombre"));
                logInUsuario.setCorreo(rs.getString("Correo"));
                logInUsuario.setChief(rs.getInt("Superior"));
                logInUsuario.setDepartamento(rs.getString("Departamento"));
            }
            
            return logInUsuario;
            
        } catch (Exception e) {
            System.out.println("Error MySQL" + e.getMessage());
            return null;
        }
    }
    
    
}
