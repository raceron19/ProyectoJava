/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import java.util.HashMap;
import javax.swing.JTable;
import sv.com.tesa.ticket.beans.EmployeeBean;
import sv.com.tesa.ticket.models.AdminBossModel;

/**
 *
 * @author Edu
 */
public class AdminBossController
{
    private AdminBossModel adminBossModelo;
    
    public AdminBossController()
    {
        adminBossModelo = new AdminBossModel();
    }
    
    public JTable listarUsuarios()
    {
        try {
            return adminBossModelo.listarJefes();
        } catch (Exception e) {
            System.out.println("Error controlador Jefe: " + e.getMessage());
            return null;
        }
    }
    
    public boolean modificarJefe(EmployeeBean beanEmpleado, boolean op)
    {
        try {
            return adminBossModelo.modificarJefe(beanEmpleado,op);
        } catch (Exception e) {
            return false;
        }
    } 
    public HashMap<Integer, String> listarRoles()
    {
        try {
            return adminBossModelo.listarRoles();
        } catch (Exception e) {
            return null;
        }
    }
    
    public HashMap<String, String> listarDepartamentos()
    {
        try {
            return adminBossModelo.listarDepartamentos();
        } catch (Exception e) {
            return null;
        }
    }
    
    
}
