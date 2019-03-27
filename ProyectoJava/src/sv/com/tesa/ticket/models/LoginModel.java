/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.models;

import java.sql.SQLException;
import org.apache.log4j.Logger;
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
                    usuario.setId(rs.getInt("id"));
                    usuario.setRol(rs.getString("Rol"));
                    usuario.setNombre(rs.getString("Nombre"));
                    usuario.setCorreo(rs.getString("Correo"));
                    usuario.setJefe(rs.getString("Superior"));
                    usuario.setDepartamento(rs.getString("Departamento"));
                    usuario.setError(rs.getString("Error"));
            }
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(ConexionModel.class).error("Error al obtener los datos",ex);
            usuario.setError("No se obtuvieron datos");
            return usuario;
        }
        finally
        {
            try {
                this.desconectar();
            } catch (SQLException ex) {
                Logger.getLogger(ConexionModel.class).error("Error al cerrar la conexiòn.",ex);
            }
        }
    }
}
