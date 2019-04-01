/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.beans;

/**
 *
 * @author vaselinux
 */
public class LoginBean {
    private static int id;
    private static String rol;
    private static String nombre;
    private static String correo;
    private static String jefe;
    private static String departamento;
    private String Error;
    public LoginBean()
    {
        id = 0;
        nombre = "";
        correo = "";
        jefe = "";
        departamento = "";
        Error = null;
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        LoginBean.id = id;
    }
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        LoginBean.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        LoginBean.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        LoginBean.correo = correo;
    }

    public String getJefe() {
        return jefe;
    }

    public void setJefe(String jefe) {
        LoginBean.jefe = jefe;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        LoginBean.departamento = departamento;
    }

    public String getError() {
        return Error;
    }

    public void setError(String Error) {
        this.Error = Error;
    }
}
