/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.utils;

import sv.com.tesa.ticket.beans.LoginBean;

/**
 *
 * @author eduar
 */
public class CurrentUser 
{
    private static int id;
    private static String rol;
    private static String nombre;
    private static String correo;
    private static String jefe;
    private static String departamento;
    public CurrentUser() 
    {
        
    }
    public CurrentUser(LoginBean loginBean) 
    {
        id = loginBean.getId();
        rol = loginBean.getRol();
        nombre = loginBean.getNombre();
        correo = loginBean.getCorreo();
        jefe = loginBean.getJefe();
        departamento = loginBean.getDepartamento();
    }
    public static int getId() {
        return id;
    }
    public static String getRol() {
        return rol;
    }
    public static String getNombre() {
        return nombre;
    }
    public static String getCorreo() {
        return correo;
    }
    public static String getJefe() {
        return jefe;
    }
    public static String getDepartamento() {
        return departamento;
    }
}
