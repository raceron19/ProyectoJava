/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sv.com.tesa.ticket.beans.LoginBean;

/**
 *
 * @author vaselinux
 */
public class LoginModel extends Conexion
{
    public LoginBean validar(String user, String password)
    {
        try {
            LoginBean usuario = new LoginBean();
            String sql = "CALL sp_select_user(?, ?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, password);
            rs = st.executeQuery();
            while(rs.next())
            {
                System.out.println(rs.getString("Correo"));
            }  
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        finally
        {   
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
