/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.tesa.ticket.controllers;
import javax.swing.JTable;
import sv.com.tesa.ticket.models.AdminDeptModel;
import sv.com.tesa.ticket.beans.DepartmentBean;
/**
 *
 * @author Edu
 */
public class AdminDeptController {
    
    private AdminDeptModel modelDept;
    
    public AdminDeptController()
    {
        modelDept = new AdminDeptModel();
    }
    
    public JTable listarDept()
    {
        try {
            return modelDept.listarDept();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public boolean ingresarDept(DepartmentBean beanDept)
    {
        try {
            return modelDept.ingresarDept(beanDept);
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public boolean modificarDept(DepartmentBean beanDept)
    {
        try {
            return modelDept.modificarDept(beanDept);
        } catch (Exception e) 
        {
            System.out.println(e.getMessage());
            return false;
        }
    }
            
    
}
