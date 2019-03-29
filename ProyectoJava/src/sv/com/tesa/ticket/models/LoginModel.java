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
public class LoginModel extends ConexionModel
{
    public LoginBean validar(String user, String password)
    {
        LoginBean usuario = new LoginBean();
        try {
            String sql = "CALL sp_select_user(?, ?)";
            this.conectar();
            st = conexion.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, password);
            rs = st.executeQuery();
            while(rs.next())
            {
                try {
                    usuario.setId(rs.getInt("id"));
                } catch (SQLException e) {
                    usuario.setId(0);
                }
                try {
                    usuario.setRol(rs.getString("Rol"));
                } catch (SQLException e) {
                    usuario.setRol(null);
                }
                try {
                    usuario.setNombre(rs.getString("Nombre"));
                } catch (SQLException e) {
                    usuario.setNombre(null);
                }
                try {
                    usuario.setCorreo(rs.getString("Correo"));
                } catch (SQLException e) {
                    usuario.setCorreo(null);
                }
                try {
                    usuario.setJefe(rs.getString("Superior"));
                } catch (SQLException e) {
                    usuario.setJefe(null);
                }
                try {
                    usuario.setDepartamento(rs.getString("Departamento"));
                } catch (SQLException e) {
                    usuario.setDepartamento(null);
                }
                usuario.setError(rs.getString("Error"));
            }
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            usuario.setError("No se obtuvieron datos");
            return usuario;
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
